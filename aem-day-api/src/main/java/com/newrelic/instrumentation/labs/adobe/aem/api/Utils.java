package com.newrelic.instrumentation.labs.adobe.aem.api;

import java.util.Map;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import org.apache.sling.api.resource.Resource;

import com.day.cq.dam.api.Asset;
import com.day.cq.dam.api.Rendition;
import com.day.cq.workflow.exec.WorkItem;
import com.day.cq.workflow.exec.Workflow;
import com.day.cq.workflow.model.WorkflowNode;

public class Utils {
	
	public static void addAttribute(Map<String, Object> attributes, String key, Object value) {
		if(attributes != null && key != null && !key.isEmpty() && value != null) {
			attributes.put(key, value);
		}
	}

	public static void addDayWorkItem(Map<String, Object> attributes, WorkItem item) {
		
		if(item != null) {
			addAttribute(attributes, "WorkItem-Id", item.getId());
			addDayWorkNode(attributes,item.getNode());
			addDayWorkflow(attributes, item.getWorkflow());
		}
	}
	
	public static void addDayWorkNode(Map<String, Object> attributes, WorkflowNode node) {
		if(node != null) {
			addAttribute(attributes, "WorkNode-Id", node.getId());
			addAttribute(attributes, "WorkNode-Title", node.getTitle());
			addAttribute(attributes, "WorkNode-Type", node.getType());
		}
	}
	
	public static void addDayWorkflow(Map<String, Object> attributes, Workflow workFlow) {
		if(workFlow != null) {
			addAttribute(attributes, "WorkFlow-Id", workFlow.getId());
			addAttribute(attributes, "WorkFlow-State", workFlow.getState());
		}
	}
	
	public static void addDayAsset(Map<String, Object> attributes, Asset asset) {
		if(asset != null) {
			addAttribute(attributes, "Asset-Name", asset.getName());
			addAttribute(attributes, "Asset-Path", asset.getPath());
			addAttribute(attributes, "Asset-MimeType", asset.getMimeType());
		}
	}

	public static void addDayNode(Map<String, Object> attributes, Node node) {
		addDayNode(attributes, node, null);
	}
	
	public static void addDayNode(Map<String, Object> attributes, Node node, String prefix) {
		if(node != null) {
			String temp = null;
			String attributeName = null;
			try {
				temp = node.getName();
				attributeName = prefix != null && !prefix.isEmpty() ? prefix + "-Node-Name" : "Node-Name";
				addAttribute(attributes, attributeName, temp);
			} catch (RepositoryException e) {
			}

			try {
				temp = node.getPath();
				attributeName = prefix != null && !prefix.isEmpty() ? prefix + "-Node-Path" : "Node-Path";
				addAttribute(attributes, attributeName, temp);
			} catch (RepositoryException e) {
			}

			try {
				temp = node.getIdentifier();
				attributeName = prefix != null && !prefix.isEmpty() ? prefix + "-Node-Identifier" : "Node-Identifier";
				addAttribute(attributes, attributeName, temp);
			} catch (RepositoryException e) {
			}

		}
	}
	
	public static void addDayRendition(Map<String, Object> attributes, Rendition rendition) {
		if(rendition != null) {
			addAttribute(attributes, "Rendition-Name", rendition.getName());
			addAttribute(attributes, "Rendition-Path", rendition.getPath());
			addAttribute(attributes, "Rendition-MimeType", rendition.getMimeType());
			addDayAsset(attributes, rendition.getAsset());
		}
	}
	
	public static void addSlingResource(Map<String,Object> attribures, Resource resource) {
		if(resource != null) {
			addAttribute(attribures, "Resource-Name", resource.getName());
			addAttribute(attribures, "Resource-Path", resource.getPath());
			addAttribute(attribures, "Resource-Type", resource.getResourceType());
		}
	}
}
