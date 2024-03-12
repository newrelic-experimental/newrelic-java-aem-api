package com.day.cq.workflow.exec;

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
public abstract class WorkflowProcess {

	@Trace(dispatcher = true)
	public void execute(WorkItem workItem, WorkflowSession session, MetaDataMap metadata) {
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		traced.setMetricName("Custom","AEM","Day","WorkflowProcess",getClass().getSimpleName(),"execute");
		HashMap<String, Object> attributes = new HashMap<>();
		Utils.addDayWorkItem(attributes, workItem);
		Weaver.callOriginal();
	}
}
