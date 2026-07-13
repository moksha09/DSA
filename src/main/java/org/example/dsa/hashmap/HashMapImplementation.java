package org.example.dsa.hashmap;

public class HashMapImplementation {

    // internally it would be n array -
    private Entity[] entities;

    public HashMapImplementation(){
        entities = new Entity[100];
    }
    private class Entity {
        String key;
        String value;

        public Entity(String key, String value){
            this.key = key;
            this.value = value;
        }
    }

    public void put(String key, String value){
        int hash = Math.abs(key.hashCode() % entities.length);
        entities[hash] = new Entity(key, value); // not good overriding
    }

    public String get(String key){
        int hash = Math.abs(key.hashCode() % entities.length);
        if(entities[hash] != null && entities[hash].key.equals(key)){
            return entities[hash].value;
        }

        return null;
    }

    public void remove(String key){
        int hash = Math.abs(key.hashCode() % entities.length);
        if(entities[hash] != null && entities[hash].key.equals(key)){
            entities[hash] = null; // not optimized
        }
    }
}
