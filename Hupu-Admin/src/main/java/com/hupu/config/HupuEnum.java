package com.hupu.config;

public interface HupuEnum {
    enum RedisExpTime implements HupuEnum {
        SHORT_TIME(300), Mid_Time(500), LongTime(700), S_LONG(900);
        private long time = 0;
        
        public long getTime() {
            return time;
        }
        
        public void setTime(int time) {
            this.time = time;
        }
        
        RedisExpTime(int value) {
            this.time = value;
        }
    }
    
    // 登录成功，密码不正确，用户名重复
    enum LogInRet implements HupuEnum {
        SUCCESS(1), PWD_UNMATCHED(200), USER_NAME_DUP(201);
        private int returnCode = 0;
        
        LogInRet(int code) {
            this.returnCode = code;
        }
        
        public int getReturnCode() {
            return returnCode;
        }
        
        public void setReturnCode(int returnCode) {
            this.returnCode = returnCode;
        }
    }
}
