/**
 * @name Find Presents
 * @id java/leaked-presents
 * @kind path-problem
 * @problem.severity error
 */

import java
private import semmle.code.java.dataflow.DataFlow
private import semmle.code.java.dataflow.TaintTracking
private import semmle.code.java.security.ExternalAPIs
private import semmle.code.java.security.InformationLeak
private import DataFlow::PathGraph

class BookCreation extends ClassInstanceExpr {
  BookCreation() { this.getConstructedType().hasQualifiedName("p", "JavaBook") }

  StringLiteral title() { result = this.getArgument(0).(StringLiteral) }
}

class BookTitleExposed extends TaintTracking::Configuration {
  BookTitleExposed() { this = "BookTitleExposed" }

  override predicate isSource(DataFlow::Node source) {
    exists(BookCreation e | e.title() = source.asExpr())
  }

  override predicate isSink(DataFlow::Node sink) { sink instanceof ExternalAPIDataNode }
}

class PresentType extends RefType {
  PresentType() { this.hasQualifiedName("p", "ChristmasPresent") }
}

from BookTitleExposed config, DataFlow::PathNode source, DataFlow::PathNode sink
where config.hasFlowPath(source, sink)
select sink, source, sink,
  "Call to " + sink.getNode().(ExternalAPIDataNode).getMethodDescription() + " exposes book title " +
    source.getNode().asExpr().(StringLiteral).getLiteral()
