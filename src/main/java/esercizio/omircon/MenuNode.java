package esercizio.omircon;

import java.util.List;

public class MenuNode {
    private Integer nodeId;
    private String nodeName;
    private String nodeType;
    private String groupType;
    private String flowType;
    private String status;
    private String landingPageType;
    private Long startValidityTs;
    private Long endValidityTs;
    private String tag;
    private List<MenuNode> nodes;
    public Integer getNodeId() {
        return nodeId;
    }

    @Override
    public String toString() {
        return "MenuNode{" +
                "nodeId=" + nodeId +
                ", nodeName='" + nodeName + '\'' +
                ", nodeType='" + nodeType + '\'' +
                ", groupType='" + groupType + '\'' +
                ", flowType='" + flowType + '\'' +
                ", status='" + status + '\'' +
                ", landingPageType='" + landingPageType + '\'' +
                ", startValidityTs=" + startValidityTs +
                ", endValidityTs=" + endValidityTs +
                ", tag='" + tag + '\'' +
                ", nodes=" + nodes +
                '}';
    }

    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public String getFlowType() {
        return flowType;
    }

    public void setFlowType(String flowType) {
        this.flowType = flowType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLandingPageType() {
        return landingPageType;
    }

    public void setLandingPageType(String landingPageType) {
        this.landingPageType = landingPageType;
    }

    public Long getStartValidityTs() {
        return startValidityTs;
    }

    public void setStartValidityTs(Long startValidityTs) {
        this.startValidityTs = startValidityTs;
    }

    public Long getEndValidityTs() {
        return endValidityTs;
    }

    public void setEndValidityTs(Long endValidityTs) {
        this.endValidityTs = endValidityTs;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }



    public List<MenuNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<MenuNode> nodes) {
        this.nodes = nodes;
    }


}
