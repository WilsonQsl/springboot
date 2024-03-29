/*
 * Copyright (c) 2020-2020, org.smartboot. All rights reserved.
 * project name: smart-license
 * file name: LicenseProtocol.java
 * Date: 2020-03-26
 * Author: sandao (zhengjunweimail@163.com)
 */

package com.sun.demo.util;


import java.io.Serializable;
import java.util.Arrays;

/**
 * License 信息实体类
 */
public final class LicenseEntity implements Serializable {

    /**
     * 魔数
     */
    public static final byte[] MAGIC_NUM = "smart-license".getBytes();
    /**
     * 随机分隔符
     */
    private final byte[] splitFlag = new byte[]{((byte) (System.nanoTime() & Byte.MAX_VALUE)),
            ((byte) (System.nanoTime() & Byte.MAX_VALUE))};
    /**
     * 公钥
     */
    private final byte[] publicKeys;
    /**
     * 申请时间
     */
    private final long applyTime = System.currentTimeMillis();

    /**
     * 过期时间
     */
    private final long expireTime;
    /**
     * 原文MD5
     */
    private final String md5;

    /**
     * 原文
     */
    private transient byte[] data;

    public LicenseEntity(long expireTime, byte[] publicKeys, String md5) {
        this.expireTime = expireTime;
        this.publicKeys = publicKeys;
        this.md5 = md5;
    }

    public byte[] getSplitFlag() {
        return splitFlag;
    }

    public long getExpireTime() {
        return expireTime;
    }

    public byte[] getPublicKeys() {
        return publicKeys;
    }

    public long getApplyTime() {
        return applyTime;
    }

    public String getMd5() {
        return md5;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "LicenseEntity{" +
                "splitFlag=" + Arrays.toString(splitFlag) +
                ", publicKeys=" + Arrays.toString(publicKeys) +
                ", applyTime=" + applyTime +
                ", expireTime=" + expireTime +
                ", md5='" + md5 + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
