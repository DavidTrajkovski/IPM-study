package finki.dnick.ipm_project.web.controllers;

import finki.dnick.ipm_project.service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class TestController {

    public final TestService testService;

    @GetMapping("/tests")
    public String getTests() {
        return "tests";
    }


    //test1
    @GetMapping("/tests-pests")
    public String getTestPests() {
        return "tests-pests";
    }

    @PostMapping("/tests-pests")
    public String getTestPestsAnswers(
            @Nullable @RequestParam List<String> PESTS_q1,
            @Nullable @RequestParam List<String> PESTS_q2,
            @Nullable @RequestParam List<String> PESTS_q3,
            @Nullable @RequestParam List<String> PESTS_q4,
            @Nullable @RequestParam List<String> PESTS_q5,
            @Nullable @RequestParam List<String> PESTS_q6,
            Model model) {
        List<List<String>> answers = new ArrayList<>();
        answers.add(PESTS_q1);
        answers.add(PESTS_q2);
        answers.add(PESTS_q3);
        answers.add(PESTS_q4);
        answers.add(PESTS_q5);
        answers.add(PESTS_q6);
        model.addAttribute("points",testService.calculatePointsPests(answers));
        return "test-pests-result.html";
    }


    //test2
    @GetMapping("/tests-ipm")
    public String getTestIPM() {
        return "tests-ipm";
    }

    @PostMapping("/tests-ipm")
    public String getTestIPMAnswers(
            @Nullable @RequestParam List<String> IPM_q1,
            @Nullable @RequestParam List<String> IPM_q2,
            @Nullable @RequestParam List<String> IPM_q3,
            @Nullable @RequestParam List<String> IPM_q4,
            @Nullable @RequestParam List<String> IPM_q5,
            @Nullable @RequestParam List<String> IPM_q6,
            @Nullable @RequestParam List<String> IPM_q7,
            @Nullable @RequestParam List<String> IPM_q8,
            Model model) {
        List<List<String>> answers = new ArrayList<>();
        answers.add(IPM_q1);
        answers.add(IPM_q2);
        answers.add(IPM_q3);
        answers.add(IPM_q4);
        answers.add(IPM_q5);
        answers.add(IPM_q6);
        answers.add(IPM_q7);
        answers.add(IPM_q8);
        model.addAttribute("points",testService.calculatePointsIPM(answers));
        return "tests-ipm-result";
    }


    //test3
    @GetMapping("/tests-pesticides")
    public String getTestPesticides() {
        return "tests-pesticides";
    }

    @PostMapping("/tests-pesticides")
    public String getTestPesticidesAnswers(
            @Nullable @RequestParam List<String> Pesticides_q1,
            @Nullable @RequestParam List<String> Pesticides_q2,
            @Nullable @RequestParam List<String> Pesticides_q3,
            @Nullable @RequestParam List<String> Pesticides_q4,
            @Nullable @RequestParam List<String> Pesticides_q5,
            @Nullable @RequestParam List<String> Pesticides_q6,
            @Nullable @RequestParam List<String> Pesticides_q7,
            @Nullable @RequestParam List<String> Pesticides_q8,
            @Nullable @RequestParam List<String> Pesticides_q9,
            @Nullable @RequestParam List<String> Pesticides_q10,
            Model model) {
        List<List<String>> answers = new ArrayList<>();
        answers.add(Pesticides_q1);
        answers.add(Pesticides_q2);
        answers.add(Pesticides_q3);
        answers.add(Pesticides_q4);
        answers.add(Pesticides_q5);
        answers.add(Pesticides_q6);
        answers.add(Pesticides_q7);
        answers.add(Pesticides_q8);
        answers.add(Pesticides_q9);
        answers.add(Pesticides_q10);
        model.addAttribute("points",testService.calculatePointsPesticides(answers));
        return "tests-pesticides-result";
    }


    //test4
    @GetMapping("/tests-ddd")
    public String getTestDDD() {
        return "tests-ddd";
    }

    @PostMapping("/tests-ddd")
    public String getTestDDDAnswers(
            @Nullable @RequestParam(required = false) List<String> DDD_q1,
            @Nullable @RequestParam(required = false) List<String> DDD_q2,
            @Nullable @RequestParam(required = false) List<String> DDD_q3,
            Model model) {
        List<List<String>> answers = new ArrayList<>();
        answers.add(DDD_q1);
        answers.add(DDD_q2);
        answers.add(DDD_q3);

        model.addAttribute("points",testService.calculatePointsDDD(answers));
        return "tests-ddd-result";
    }
}
