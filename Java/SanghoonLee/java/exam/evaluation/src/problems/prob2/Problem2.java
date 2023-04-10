package problems.prob2;

import customLibrary.company.Company;

public class Problem2 {
    public static void main(String[] args) {
        final Company company = new Company(
                "상호명", 1000000000,
                4, 100000000);

        System.out.println(company);
    }
}
