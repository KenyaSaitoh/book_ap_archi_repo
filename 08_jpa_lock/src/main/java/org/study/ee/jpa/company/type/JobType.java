package org.study.ee.jpa.company.type;

public enum JobType {
    MANAGER("マネージャ"),
    PROJECT_LEADER("プロジェクトリーダ"),
    ARCHITECT("アーキテクト"),
    SYSTEM_ENGINEER("システムエンジニア"),
    PROGRAMMER("プログラマ");

    private final String jobType;

    JobType(String jobType) {
        this.jobType = jobType;
    }

    public String toString() {
        return jobType;
    }
}