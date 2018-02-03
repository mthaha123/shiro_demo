package com.shiroDemo.common.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.springframework.cache.support.SimpleValueWrapper;

import java.util.Collection;
import java.util.Set;

/**
 * shiro使用的缓存
 * 包装spring cache抽象
 */
public class CustomShiroCacheManager implements CacheManager {

    private org.springframework.cache.CacheManager springCacheManager;

    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        org.springframework.cache.Cache springCache = springCacheManager.getCache(s);
        return new SpringCacheWrapper(springCache);
    }

    static class  SpringCacheWrapper<K,V> implements Cache<K,V>{
        private org.springframework.cache.Cache springCache;

        public SpringCacheWrapper(org.springframework.cache.Cache springCache) {
            this.springCache = springCache;
        }

        public Object get(Object key) throws CacheException {
            Object value = springCache.get(key);
            if(value instanceof SimpleValueWrapper){
                return ((SimpleValueWrapper)value).get();
            }
            return value;
        }

        public Object put(Object key, Object value) throws CacheException {
            springCache.put(key,value);
            return value;
        }

        public Object remove(Object key) throws CacheException {
            springCache.evict(key);
            return null;
        }

        public void clear() throws CacheException {
            springCache.clear();
        }

        public int size() {
            throw  new UnsupportedOperationException("invoke spring cache abstract size method not supported");
        }

        public Set keys() {
            throw  new UnsupportedOperationException("invoke spring cache abstract keys method not supported");
        }

        public Collection values() {
            throw  new UnsupportedOperationException("invoke spring cache abstract values method not supported");
        }
    }




    public org.springframework.cache.CacheManager getSpringCacheManager() {
        return springCacheManager;
    }

    public void setSpringCacheManager(org.springframework.cache.CacheManager springCacheManager) {
        this.springCacheManager = springCacheManager;
    }
}
