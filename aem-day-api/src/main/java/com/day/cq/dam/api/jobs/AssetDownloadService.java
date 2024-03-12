package com.day.cq.dam.api.jobs;

import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import java.util.zip.ZipOutputStream;

import org.apache.sling.api.resource.Resource;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TracedMethod;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.adobe.aem.api.Utils;

@Weave(type = MatchType.Interface)
public abstract class AssetDownloadService {

	@Trace
	public String assetDownload(Resource configResource, Set<Resource> downloadSet, boolean downloadAssets, boolean downloadRenditions, boolean downloadSubassets, String s7ExportSettings,
			Date date, ZipOutputStream out, String downloadName, String emailRecipients) {
		HashMap<String, Object> attributes = new HashMap<>();
		TracedMethod traced = NewRelic.getAgent().getTracedMethod();
		traced.setMetricName("Custom","AEM","Day","AssetDownloadService",getClass().getSimpleName(),"assetDownload");
		Utils.addSlingResource(attributes, configResource);
		Utils.addAttribute(attributes, "DownloadAssets", downloadSet);
		Utils.addAttribute(attributes, "DownloadName", downloadName);
		Utils.addAttribute(attributes, "DownloadRenditions", downloadRenditions);
		Utils.addAttribute(attributes, "DownloadSubassets", downloadSubassets);

		return Weaver.callOriginal();
	}
}
