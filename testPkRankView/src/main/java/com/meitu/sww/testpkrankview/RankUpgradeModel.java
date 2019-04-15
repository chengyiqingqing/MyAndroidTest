package com.meitu.sww.testpkrankview;

/**
 * @author ShaoWenWen
 * @date 2019/4/12
 */
public class RankUpgradeModel {

    // 段位类型：可以标识背景 0,1,2,3,4.
    private int pkRankedType;
    // 段位描述：该段位下的等级描述 0,1,2,3,
    private String pkRankedName;

    public RankUpgradeModel(int pkRankedType, String pkRankedName) {
        this.pkRankedType = pkRankedType;
        this.pkRankedName = pkRankedName;
    }

    public int getPkRankedType() {
        return pkRankedType;
    }

    public void setPkRankedType(int pkRankedType) {
        this.pkRankedType = pkRankedType;
    }

    public String getPkRankedName() {
        return pkRankedName;
    }

    public void setPkRankedName(String pkRankedName) {
        this.pkRankedName = pkRankedName;
    }

}
