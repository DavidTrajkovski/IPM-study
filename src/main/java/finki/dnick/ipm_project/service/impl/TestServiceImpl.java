package finki.dnick.ipm_project.service.impl;

import finki.dnick.ipm_project.service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TestServiceImpl implements TestService {

    @Override
    public double calculatePointsPests(List<List<String>> answers) {
        double points = 0.0;

        List<String> odgovori1 = answers.get(0);
        List<String> odgovori2 = answers.get(1);
        List<String> odgovori3 = answers.get(2);
        List<String> odgovori4 = answers.get(3);
        List<String> odgovori5 = answers.get(4);
        List<String> odgovori6 = answers.get(5);

        if (odgovori1 != null) {
            if (odgovori1.contains("q1-a1")) points += 15;
        }

        if (odgovori2 != null) {
            if (odgovori2.contains("q2-a2")) points += 15;
        }

        if (odgovori3 != null) {
            if (odgovori3.containsAll(List.of("q3-a1","q3-a3","q3-a5","q3-a6")) && odgovori3.size()==4)
                points += 20;
            else if (odgovori3.containsAll(List.of("q3-a1","q3-a3","q3-a5","q3-a6")) && (odgovori3.size()==5 || odgovori3.size()==6))
                points += 15;
            else if ((odgovori3.containsAll(List.of("q3-a1","q3-a3","q3-a5")) || odgovori3.containsAll(List.of("q3-a1","q3-a3","q3-a6")) || odgovori3.containsAll(List.of("q3-a5","q3-a3","q3-a6"))) && odgovori3.size()==3)
                points += 15;
            else if ((odgovori3.containsAll(List.of("q3-a1","q3-a3","q3-a5")) || odgovori3.containsAll(List.of("q3-a1","q3-a3","q3-a6")) || odgovori3.containsAll(List.of("q3-a5","q3-a3","q3-a6"))) && (odgovori3.size()==4 || odgovori3.size()==5))
                points += 10;
            else if ((odgovori3.containsAll(List.of("q3-a1","q3-a3")) || odgovori3.containsAll(List.of("q3-a1","q3-a5")) || odgovori3.containsAll(List.of("q3-a1","q3-a6")) || odgovori3.containsAll(List.of("q3-a3","q3-a5")) || odgovori3.containsAll(List.of("q3-a3","q3-a6")) || odgovori3.containsAll(List.of("q3-a6","q3-a5"))) && odgovori3.size()==2)
                points += 10;
            else if ((odgovori3.containsAll(List.of("q3-a1","q3-a3")) || odgovori3.containsAll(List.of("q3-a1","q3-a5")) || odgovori3.containsAll(List.of("q3-a1","q3-a6")) || odgovori3.containsAll(List.of("q3-a3","q3-a5")) || odgovori3.containsAll(List.of("q3-a3","q3-a6")) || odgovori3.containsAll(List.of("q3-a6","q3-a5"))) && (odgovori3.size()==3 || odgovori3.size()==4))
                points += 5;
            else if ((odgovori3.contains("q3-a1") || odgovori3.contains("q3-a3") || odgovori3.contains("q3-a6") || odgovori3.contains("q3-a5")) && odgovori3.size()==1)
                points += 5;
            else if ((odgovori3.contains("q3-a1") || odgovori3.contains("q3-a3") || odgovori3.contains("q3-a6") || odgovori3.contains("q3-a5")) && (odgovori3.size()==2 || odgovori3.size()==3))
                points += 0;
        } else points += 0;

        if (odgovori4 != null) {
            if (odgovori4.contains("q4-a1")) points += 15;
        }

        if (odgovori5 != null) {
            if (odgovori5.containsAll(List.of("q5-a1","q5-a3")) && odgovori5.size()==2)
                points += 15;
            else if (odgovori5.containsAll(List.of("q5-a1","q5-a3")) && (odgovori5.size()==3 || odgovori5.size()==4))
                points += 7.5;
            else if ((odgovori5.contains("q5-a1") || odgovori5.contains("q5-a3")) && odgovori5.size()==1)
                points += 7.5;
            else if ((odgovori5.contains("q5-a1") || odgovori5.contains("q5-a3")) && (odgovori5.size()==2 || odgovori5.size()==3))
                points += 0;
        } else points += 0;

        if (odgovori6 != null) {
            if (odgovori6.containsAll(List.of("q6-a1","q6-a3","q6-a4","q6-a6")) && odgovori6.size()==4)
                points += 20;
            else if (odgovori6.containsAll(List.of("q6-a1","q6-a3","q6-a4","q6-a6")) && (odgovori6.size()==5 || odgovori6.size()==6))
                points += 15;
            else if ((odgovori6.containsAll(List.of("q6-a1","q6-a3","q6-a4")) || odgovori6.containsAll(List.of("q6-a1","q6-a3","q6-a6")) || odgovori6.containsAll(List.of("q6-a4","q6-a3","q6-a6"))) && odgovori6.size()==3)
                points += 15;
            else if ((odgovori6.containsAll(List.of("q6-a1","q6-a3","q6-a4")) || odgovori6.containsAll(List.of("q6-a1","q6-a3","q6-a6")) || odgovori6.containsAll(List.of("q6-a4","q6-a3","q6-a6"))) && (odgovori6.size()==4 || odgovori6.size()==5))
                points += 10;
            else if ((odgovori6.containsAll(List.of("q6-a1","q6-a3")) || odgovori6.containsAll(List.of("q6-a1","q6-a4")) || odgovori6.containsAll(List.of("q6-a1","q6-a6")) || odgovori6.containsAll(List.of("q6-a3","q6-a4")) || odgovori6.containsAll(List.of("q6-a3","q6-a6")) || odgovori6.containsAll(List.of("q6-a6","q6-a4"))) && odgovori6.size()==2)
                points += 10;
            else if ((odgovori6.containsAll(List.of("q6-a1","q6-a3")) || odgovori6.containsAll(List.of("q6-a1","q6-a4")) || odgovori6.containsAll(List.of("q6-a1","q6-a6")) || odgovori6.containsAll(List.of("q6-a3","q6-a4")) || odgovori6.containsAll(List.of("q6-a3","q6-a6")) || odgovori6.containsAll(List.of("q6-a6","q6-a4"))) && (odgovori6.size()==3 || odgovori6.size()==4))
                points += 5;
            else if ((odgovori6.contains("q6-a1") || odgovori6.contains("q6-a3") || odgovori6.contains("q6-a6") || odgovori6.contains("q6-a4")) && odgovori6.size()==1)
                points += 5;
            else if ((odgovori6.contains("q6-a1") || odgovori6.contains("q6-a3") || odgovori6.contains("q6-a6") || odgovori6.contains("q6-a4")) && (odgovori6.size()==2 || odgovori6.size()==3))
                points += 0;
        } else  points += 0;

        return points;
    }

    @Override
    public double calculatePointsIPM(List<List<String>> answers) {
        double points = 0.0;

        List<String> odgovori1 = answers.get(0);
        List<String> odgovori2 = answers.get(1);
        List<String> odgovori3 = answers.get(2);
        List<String> odgovori4 = answers.get(3);
        List<String> odgovori5 = answers.get(4);
        List<String> odgovori6 = answers.get(5);
        List<String> odgovori7 = answers.get(6);
        List<String> odgovori8 = answers.get(7);

        if (odgovori1 != null) {
            if (odgovori1.contains("q1-a3")) points += 10;
        }

        if (odgovori2 != null) {
            if (odgovori2.contains("q2-a1")) points += 10;
        }

        if (odgovori3 != null) {
            if (odgovori3.contains("q3-a3")) points += 10;
        }

        if (odgovori4 != null) {
            if (odgovori4.contains("q4-a1")) points += 10;
        }

        if (odgovori5 != null) {
            if (odgovori5.containsAll(List.of("q5-a1","q5-a3","q5-a4","q5-a6")) && odgovori5.size()==4)
                points += 30;
            else if (odgovori5.containsAll(List.of("q5-a1","q5-a3","q5-a4","q5-a6")) && (odgovori5.size()==5))
                points += 22.5;
            else if ((odgovori5.containsAll(List.of("q5-a1","q5-a3","q5-a4")) || odgovori5.containsAll(List.of("q5-a1","q5-a3","q5-a6")) || odgovori5.containsAll(List.of("q5-a4","q5-a3","q5-a6"))) && odgovori5.size()==3)
                points += 22.5;
            else if ((odgovori5.containsAll(List.of("q5-a1","q5-a3","q5-a4")) || odgovori5.containsAll(List.of("q5-a1","q5-a3","q5-a6")) || odgovori5.containsAll(List.of("q5-a4","q5-a3","q5-a6"))) && (odgovori5.size()==4))
                points += 15;
            else if ((odgovori5.containsAll(List.of("q5-a1","q5-a3")) || odgovori5.containsAll(List.of("q5-a1","q5-a4")) || odgovori5.containsAll(List.of("q5-a1","q5-a6")) || odgovori5.containsAll(List.of("q5-a3","q5-a4")) || odgovori5.containsAll(List.of("q5-a3","q5-a6")) || odgovori5.containsAll(List.of("q5-a6","q5-a4"))) && odgovori5.size()==2)
                points += 15;
            else if ((odgovori5.containsAll(List.of("q5-a1","q5-a3")) || odgovori5.containsAll(List.of("q5-a1","q5-a4")) || odgovori5.containsAll(List.of("q5-a1","q5-a6")) || odgovori5.containsAll(List.of("q5-a3","q5-a4")) || odgovori5.containsAll(List.of("q5-a3","q5-a6")) || odgovori5.containsAll(List.of("q5-a6","q5-a4"))) && (odgovori5.size()==3))
                points += 7.5;
            else if ((odgovori5.contains("q5-a1") || odgovori5.contains("q5-a3") || odgovori5.contains("q5-a6") || odgovori5.contains("q5-a4")) && odgovori5.size()==1)
                points += 7.5;
            else if ((odgovori5.contains("q5-a1") || odgovori5.contains("q5-a3") || odgovori5.contains("q5-a6") || odgovori5.contains("q5-a4")) && (odgovori5.size()==2))
                points += 0;
        } else  points += 0;

        if (odgovori6 != null) {
            if (odgovori6.contains("q6-a1")) points += 10;
        }

        if (odgovori7 != null) {
            if (odgovori7.contains("q7-a2")) points += 10;
        }

        if (odgovori8 != null) {
            if (odgovori8.containsAll(List.of("q8-a1","q8-a3")) && odgovori8.size()==2)
                points += 10;
            else if (odgovori8.containsAll(List.of("q8-a1","q8-a3")) && (odgovori8.size()==3 || odgovori8.size()==4))
                points += 5;
            else if ((odgovori8.contains("q8-a1") || odgovori8.contains("q8-a3")) && odgovori8.size()==1)
                points += 5;
            else if ((odgovori8.contains("q8-a1") || odgovori8.contains("q8-a3")) && (odgovori8.size()==2 || odgovori8.size()==3))
                points += 0;
        } else points += 0;

        return points;
    }

    @Override
    public double calculatePointsPesticides(List<List<String>> answers) {
        double points = 0.0;

        List<String> odgovori1 = answers.get(0);
        List<String> odgovori2 = answers.get(1);
        List<String> odgovori3 = answers.get(2);
        List<String> odgovori4 = answers.get(3);
        List<String> odgovori5 = answers.get(4);
        List<String> odgovori6 = answers.get(5);
        List<String> odgovori7 = answers.get(6);
        List<String> odgovori8 = answers.get(7);
        List<String> odgovori9 = answers.get(8);
        List<String> odgovori10 = answers.get(9);

        if (odgovori1 != null) {
            if (odgovori1.contains("q1-a2")) points += 8;
        }

        if (odgovori2 != null) {
            if (odgovori2.contains("q2-a2")) points += 8;
        }

        if (odgovori3 != null) {
            if (odgovori3.containsAll(List.of("q3-a1","q3-a2")) && odgovori3.size()==2)
                points += 9;
            else if (odgovori3.containsAll(List.of("q3-a1","q8-a2")) && (odgovori3.size()==3 || odgovori3.size()==4))
                points += 4.5;
            else if ((odgovori3.contains("q3-a1") || odgovori3.contains("q3-a2")) && odgovori3.size()==1)
                points += 4.5;
            else if ((odgovori3.contains("q3-a1") || odgovori3.contains("q3-a2")) && (odgovori3.size()==2 || odgovori3.size()==3))
                points += 0;
        } else points += 0;

        if (odgovori4 != null) {
            if (odgovori4.containsAll(List.of("q4-a1","q4-a2","q4-a4")) && odgovori4.size()==3)
                points += 15;
            else if (odgovori4.containsAll(List.of("q4-a1","q4-a2","q4-a4")) && odgovori4.size()==4)
                points += 10;
            else if ((odgovori4.containsAll(List.of("q4-a1","q4-a2")) || odgovori4.containsAll(List.of("q4-a1","q4-a4")) || odgovori4.containsAll(List.of("q4-a2","q4-a4"))) && odgovori4.size()==2)
                points += 10;
            else if ((odgovori4.containsAll(List.of("q4-a1","q4-a2")) || odgovori4.containsAll(List.of("q4-a1","q4-a4")) || odgovori4.containsAll(List.of("q4-a2","q4-a4"))) && odgovori4.size()==3)
                points += 5;
            else if ((odgovori4.contains("q4-a1") || odgovori4.contains("q4-a2") || odgovori4.contains("q4-a4")) && odgovori4.size()==1)
                points += 5;
            else if ((odgovori4.contains("q4-a1") || odgovori4.contains("q4-a2") || odgovori4.contains("q4-a4")) && odgovori4.size()==2)
                points += 0;
        } else  points += 0;

        if (odgovori5 != null) {
            if (odgovori5.contains("q5-a3")) points += 8;
        }

        if (odgovori6 != null) {
            if (odgovori6.contains("q6-a2")) points += 8;
        }

        if (odgovori7 != null) {
            if (odgovori7.contains("q7-a1")) points += 8;
        }

        if (odgovori8 != null) {
            if (odgovori8.contains("q8-a2")) points += 8;
        }

        if (odgovori9 != null) {
            if (odgovori9.contains("q9-a1")) points += 8;
        }

        if (odgovori10 != null) {
            if (odgovori10.containsAll(List.of("q10-a1","q10-a3","q10-a4","q10-a5")) && odgovori10.size()==4)
                points += 20;
            else if (odgovori10.containsAll(List.of("q10-a1","q10-a3","q10-a4","q10-a5")) && odgovori10.size()==5)
                points += 15;
            else if ((odgovori10.containsAll(List.of("q10-a1","q10-a3","q10-a4")) || odgovori10.containsAll(List.of("q10-a1","q10-a3","q10-a5")) || odgovori10.containsAll(List.of("q10-a5","q10-a3","q10-a4"))) && odgovori10.size()==3)
                points += 15;
            else if ((odgovori10.containsAll(List.of("q10-a1","q10-a3","q10-a4")) || odgovori10.containsAll(List.of("q10-a1","q10-a3","q10-a5")) || odgovori10.containsAll(List.of("q10-a5","q10-a3","q10-a4"))) && odgovori10.size()==4)
                points += 10;
            else if ((odgovori10.containsAll(List.of("q10-a1","q10-a3")) || odgovori10.containsAll(List.of("q10-a1","q10-a4")) || odgovori10.containsAll(List.of("q10-a1","q10-a5")) || odgovori10.containsAll(List.of("q10-a3","q10-a4")) || odgovori10.containsAll(List.of("q10-a3","q10-a5")) || odgovori10.containsAll(List.of("q10-a4","q10-a5"))) && odgovori10.size()==2)
                points += 10;
            else if ((odgovori10.containsAll(List.of("q10-a1","q10-a3")) || odgovori10.containsAll(List.of("q10-a1","q10-a4")) || odgovori10.containsAll(List.of("q10-a1","q10-a5")) || odgovori10.containsAll(List.of("q10-a3","q10-a4")) || odgovori10.containsAll(List.of("q10-a3","q10-a5")) || odgovori10.containsAll(List.of("q10-a4","q10-a5"))) && odgovori10.size()==3)
                points += 5;
            else if ((odgovori10.contains("q10-a1") || odgovori10.contains("q10-a3") || odgovori10.contains("q10-a4") || odgovori10.contains("q10-a5")) && odgovori10.size()==1)
                points += 5;
            else if ((odgovori10.contains("q10-a1") || odgovori10.contains("q10-a3") || odgovori10.contains("q10-a4") || odgovori10.contains("q10-a5")) && odgovori10.size()==2)
                points += 0;
        } else  points += 0;

        return points;
    }

    @Override
    public double calculatePointsDDD(List<List<String>> answers) {
        double points = 0.0;
        List<String> odgovori1 = answers.get(0);
        List<String> odgovori2 = answers.get(1);
        List<String> odgovori3 = answers.get(2);

        if (odgovori1 != null) {
            if (odgovori1.containsAll(List.of("q1-a1","q1-a3","q1-a4")) && odgovori1.size()==3)
                points += 30;
            else if (odgovori1.containsAll(List.of("q1-a1","q1-a3","q1-a4")) && odgovori1.size()==4)
                points += 20;
            else if ((odgovori1.containsAll(List.of("q1-a1","q1-a3")) || odgovori1.containsAll(List.of("q1-a1","q1-a4")) || odgovori1.containsAll(List.of("q1-a3","q1-a4"))) && odgovori1.size()==2)
                points += 20;
            else if ((odgovori1.containsAll(List.of("q1-a1","q1-a3")) || odgovori1.containsAll(List.of("q1-a1","q1-a4")) || odgovori1.containsAll(List.of("q1-a3","q1-a4"))) && odgovori1.size()==3)
                points += 10;
            else if ((odgovori1.contains("q1-a1") || odgovori1.contains("q1-a4") || odgovori1.contains("q1-a3")) && odgovori1.size()==1)
                points += 10;
            else if ((odgovori1.contains("q1-a1") || odgovori1.contains("q1-a4") || odgovori1.contains("q1-a3")) && odgovori1.size()==2)
                points += 0;
        } else  points += 0;

        if (odgovori2 != null) {
            if (odgovori2.containsAll(List.of("q2-a1","q2-a2","q2-a3")) && odgovori2.size()==3)
                points += 30;
            else if (odgovori2.containsAll(List.of("q2-a1","q2-a2","q2-a3")) && odgovori2.size()==4)
                points += 20;
            else if ((odgovori2.containsAll(List.of("q2-a1","q2-a2")) || odgovori2.containsAll(List.of("q2-a1","q2-a3")) || odgovori2.containsAll(List.of("q2-a2","q2-a3"))) && odgovori2.size()==2)
                points += 20;
            else if ((odgovori2.containsAll(List.of("q2-a1","q2-a2")) || odgovori2.containsAll(List.of("q2-a1","q2-a3")) || odgovori2.containsAll(List.of("q2-a2","q2-a3"))) && odgovori2.size()==3)
                points += 10;
            else if ((odgovori2.contains("q2-a1") || odgovori2.contains("q2-a2") || odgovori2.contains("q2-a3")) && odgovori2.size()==1)
                points += 10;
            else if ((odgovori2.contains("q2-a1") || odgovori2.contains("q2-a2") || odgovori2.contains("q2-a3")) && odgovori2.size()==2)
                points += 0;
        } else  points += 0;

        if (odgovori3 != null) {
            if (odgovori3.containsAll(List.of("q3-a1","q3-a3","q3-a4","q3-a5")) && odgovori3.size()==4)
                points += 40;
            else if (odgovori3.containsAll(List.of("q3-a1","q3-a3","q3-a4","q3-a5")) && odgovori3.size()==5)
                points += 30;
            else if ((odgovori3.containsAll(List.of("q3-a1","q3-a3","q3-a4")) || odgovori3.containsAll(List.of("q3-a1","q3-a3","q3-a5")) || odgovori3.containsAll(List.of("q3-a5","q3-a3","q3-a4"))) && odgovori3.size()==3)
                points += 30;
            else if ((odgovori3.containsAll(List.of("q3-a1","q3-a3","q3-a4")) || odgovori3.containsAll(List.of("q3-a1","q3-a3","q3-a5")) || odgovori3.containsAll(List.of("q3-a5","q3-a3","q3-a4"))) && odgovori3.size()==4)
                points += 20;
            else if ((odgovori3.containsAll(List.of("q3-a1","q3-a3")) || odgovori3.containsAll(List.of("q3-a1","q3-a4")) || odgovori3.containsAll(List.of("q3-a1","q3-a5")) || odgovori3.containsAll(List.of("q3-a3","q3-a4")) || odgovori3.containsAll(List.of("q3-a3","q3-a5")) || odgovori3.containsAll(List.of("q3-a4","q3-a5"))) && odgovori3.size()==2)
                points += 20;
            else if ((odgovori3.containsAll(List.of("q3-a1","q3-a3")) || odgovori3.containsAll(List.of("q3-a1","q3-a4")) || odgovori3.containsAll(List.of("q3-a1","q3-a5")) || odgovori3.containsAll(List.of("q3-a3","q3-a4")) || odgovori3.containsAll(List.of("q3-a3","q3-a5")) || odgovori3.containsAll(List.of("q3-a4","q3-a5"))) && odgovori3.size()==3)
                points += 10;
            else if ((odgovori3.contains("q3-a1") || odgovori3.contains("q3-a3") || odgovori3.contains("q3-a4") || odgovori3.contains("q3-a5")) && odgovori3.size()==1)
                points += 10;
            else if ((odgovori3.contains("q3-a1") || odgovori3.contains("q3-a3") || odgovori3.contains("q3-a4") || odgovori3.contains("q3-a5")) && odgovori3.size()==2)
                points += 0;
        } else  points += 0;

        return points;
    }
}
