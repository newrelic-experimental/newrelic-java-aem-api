package com.day.cq.workflow.exec;

import java.util.HashMap;

import com.day.cq.workflow.WorkflowSession;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TracedMethod;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.adobe.aem.api.Utils;

@Weave(type = MatchType.Interface)
public abstract class JavaProcess {

	@Trace
	public void execute(WorkItem item, WorkflowSession session) {
		HashMap<String, Object> attributes = new HashMap<>();
		Utils.addDayWorkItem(attributes, item);
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		traced.addCustomAttributes(attributes);
		traced.setMetricName("Custom","AEM","Day","JavaProcess",getClass().getSimpleName(),"execute");
		Weaver.callOriginal();
	}
}
