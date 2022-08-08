package finki.dnick.ipm_project.service;

import java.util.List;

public interface TestService {
    double calculatePointsIPM(List<List<String>> answers);
    double calculatePointsPests(List<List<String>> answers);
    double calculatePointsPesticides(List<List<String>> answers);
    double calculatePointsDDD(List<List<String>> answers);
}
