package com.alinesno.infra.base.storage.enums;

/**
 * 文件保存策略枚举类
 * <p>
 * 该枚举类定义了文件保存的策略，包括本地、七牛、阿里云和私有云。
 * </p>
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
public enum StrategyEnums {

    LOCAL("local", "本地"),
    QINIU("qiniu", "七牛"),
    ALIOSS("alioss", "阿里云"),
    MINIO("minio", "私有云");

    private String value;
    private String label;

    private StrategyEnums(String value, String label) {
        this.value = value;
        this.label = label;
    }

    /**
     * 获取枚举值
     *
     * @return 枚举值
     */
    public String value() {
        return value;
    }

    /**
     * 获取枚举值
     *
     * @return 枚举值
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置枚举值
     *
     * @param value 枚举值
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 获取枚举标签
     *
     * @return 枚举标签
     */
    public String getLabel() {
        return label;
    }

    /**
     * 设置枚举标签
     *
     * @param label 枚举标签
     */
    public void setLabel(String label) {
        this.label = label;
    }
}
