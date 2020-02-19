package com.LeetCode.Easy12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P811_SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer> count = new HashMap<>();
        for(String S:cpdomains){
            //此题\\s+、\\s、“ ”都可以
            String[] domain = S.split("\\s+");
            //“.”和“|”都是转义字符，必须得加"\\";
            String[] letterPart = domain[1].split("\\.");
            int digitPart = Integer.parseInt(domain[0]);
            String domainPart = "";
            for(int i = letterPart.length-1;i>=0;i--){
                domainPart = letterPart[i]+(i<letterPart.length-1?".":"")+domainPart;
                count.put(domainPart,count.getOrDefault(domainPart,0)+digitPart);
            }
        }
        List<String> ans = new ArrayList<>();
        for(String dom:count.keySet()){
            ans.add(""+count.get(dom)+" " +dom);
        }
        return ans ;
    }
    public static void main(String[] args) {
        System.out.println(
                new P811_SubdomainVisitCount().subdomainVisits(
                        new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}
                )
        );
    }
}
