package org.practise.guava.multiMap;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.Collection;

public class MultiMapTest {

    public static void main(String[] args) {


        Multimap<String,StudentScore> scoreMultimap = ArrayListMultimap.create();
        for(int i=10;i<20;i++){
            StudentScore studentScore=new StudentScore();
            studentScore.CourseId=1001+i;
            studentScore.score=100-i;
            scoreMultimap.put("peida",studentScore);
        }
        System.out.println("scoreMultimap:"+scoreMultimap.size());
        System.out.println("scoreMultimap:"+scoreMultimap.keys());

        Collection<StudentScore> studentScore = scoreMultimap.get("peida");
        StudentScore studentScore1=new StudentScore();
        studentScore1.CourseId=1034;
        studentScore1.score=67;
        studentScore.add(studentScore1);

        StudentScore studentScore2=new StudentScore();
        studentScore2.CourseId=1045;
        studentScore2.score=56;
        scoreMultimap.put("jerry",studentScore2);

        System.out.println("scoreMultimap:"+scoreMultimap.size());
        System.out.println("scoreMultimap:"+scoreMultimap.keys());


        for(StudentScore stuScore : scoreMultimap.values()) {
            System.out.println("stuScore one:"+stuScore.CourseId+" score:"+stuScore.score);
        }

        scoreMultimap.remove("jerry",studentScore2);
        System.out.println("scoreMultimap:"+scoreMultimap.size());
        System.out.println("scoreMultimap:"+scoreMultimap.get("jerry"));

        scoreMultimap.put("harry",studentScore2);
        scoreMultimap.removeAll("harry");
        System.out.println("scoreMultimap:"+scoreMultimap.size());
        System.out.println("scoreMultimap:"+scoreMultimap.get("harry"));
    }
}
