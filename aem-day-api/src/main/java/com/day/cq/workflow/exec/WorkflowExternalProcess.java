package com.day.cq.workflow.exec;

import java.io.Serializable;
import java.util.HashMap;

import com.day.cq.workflow.WorkflowSession;
import com.day.cq.workflow.metadata.MetaDataMap;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TracedMethod;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.adobe.aem.api.Utils;

@Weave(type = MatchType.Interface)
public abstract class WorkflowExternalProcess {

	@Trace
	public Serializable execute(WorkItem workItem, WorkflowSession session, MetaDataMap metadata) {
		HashMap<String, Object> attributes = new HashMap<>();
		Utils.addDayWorkItem(attributes, workItem);
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		traced.addCustomAttributes(attributes);
		traced.setMetricName("Custom","AEM","Day","WorkflowExternalProcess",getClass().getSimpleName(),"execute");
		return Weaver.callOriginal();
	}
	
	@Trace
	public void handleResult(Serializable var1, WorkItem workItem, WorkflowSession session, MetaDataMap metadata) {
		HashMap<String, Object> attributes = new HashMap<>();
		Utils.addDayWorkItem(attributes, workItem);
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		traced.addCustomAttributes(attributes);
		traced.setMetricName("Custom","AEM","Day","WorkflowExternalProcess",getClass().getSimpleName(),"execute");
		Weaver.callOriginal();
	}
}
