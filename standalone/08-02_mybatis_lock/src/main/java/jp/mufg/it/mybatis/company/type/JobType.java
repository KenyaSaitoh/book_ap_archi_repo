package jp.mufg.it.mybatis.company.type;

public enum JobType {
    MANAGER("マネージャ"),
    LEADER("リーダー"),
    CHIEF("チーフ"),
    ASSOCIATE("アソシエイト");

    private final String jobType;

    JobType(String jobType) {
        this.jobType = jobType;
    }

    public String toString() {
        return jobType;
    }
}