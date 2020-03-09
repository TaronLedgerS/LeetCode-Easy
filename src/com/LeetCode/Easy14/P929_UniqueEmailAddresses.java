package com.LeetCode.Easy14;

import java.util.HashSet;
import java.util.Set;

public class P929_UniqueEmailAddresses {

    public int numUniqueEmails(String[] emails) {

        Set<String> emailsSet = new HashSet<>();
        for (String e : emails)
            emailsSet.add(getEmails(e));
        return emailsSet.size();
    }
    private String getEmails(String e){
            StringBuilder sb = new StringBuilder();
            boolean visitedAt = false;
            boolean visitedPlus = false;
            for(char c:e.toCharArray()){
            if(c=='@') visitedAt = true;
            if(!visitedAt){
            if(visitedPlus) continue;
            if(c=='.') continue;
            if(c=='+') {
            visitedPlus = true;
            continue;
            }

            sb.append(c);
            }else{
            sb.append(c);
            }
            }
            //System.out.println(sb.toString());
            return sb.toString();
            }
}
