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
public abstract class JavaProcessExt {

	@Trace(dispatcher = true)
	public void execute(WorkItem workItem, WorkflowSession session, String[] var3) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		traced.setMetricName("Custom","AEM","Day","JavaProcessExt",getClass().getSimpleName(),"execute");
		HashMap<String,Object> attributes = new HashMap<>();
		Utils.addDayWorkItem(attributes, workItem);
		traced.addCustomAttributes(attributes);
		Weaver.callOriginal();
	}
}
