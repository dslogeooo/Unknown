package com.xxxx.设计类;

import com.alibaba.fastjson.JSONObject;
import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class 实现递归的map结构 {
}

@Data
class Permission{
    private String name;
    private int id;
    private int pid;
    private List<Permission> children = new ArrayList<Permission>();

    public List<Permission> getPermission(){
        Map<Integer,Permission> permissionMap = new HashMap<>();
        List<Permission> permissions = new ArrayList<>();

        List<Permission> ps = (List<Permission>) Json.parse("\"a\"");

        for(Permission p : ps){
            permissionMap.put(p.getId(),p);
        }
        for (Permission p : ps){
            Permission child = p;
            if(child.getId() == 0){
                permissions.add(child);
            }else{
                Permission parent = permissionMap.get(child.getPid());
                parent.getChildren().add(child);
            }
        }
        return permissions;
    }
}

@Data
class Datas {
    private int id;
    private int pid;
    private String name;
    private List<Datas> children = new ArrayList<>();

    public Datas() {
    }

    public Datas(int id, int pid, String name, List<Datas> datas) {
        this.id = id;
        this.pid = pid;
        this.name = name;
        this.children = datas;
    }
}

class Struct{
    public Struct (){};
    public List<Datas> getDatas(String str){
        List<Datas> datas = new ArrayList<>();
        Map<Integer,Datas> datasMap = new HashMap<>();

        JSONObject ss = JSONObject.parseObject(str);
        List<Datas> ds = new ArrayList<>();
        for (int i = 0; i < ss.size(); i++) {
//            Datas newds = new Datas(ss.get(i).getID,ss.get(i).getPID,ss.get(i).getNAME,ss.get(i).getCHILDREN);
            ds.add((Datas) ss.get(i));
        }
        for (Datas d:ds){
            datasMap.put(d.getId(),d);
        }
        for (Datas d:ds){
            Datas child = d;
            if(child.getPid()==0){
                datas.add(child);
            }else{
                Datas parent = datasMap.get(child.getPid());
                parent.getChildren().add(child);
            }
        }
        return datas;
    }
}
