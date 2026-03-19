package ra.entity;

import java.util.Scanner;

public class Team {
    private String teamId;
    private String teamName;
    private int memberCount;
    private double averageWeight;

    public Team() {}

    public String getTeamId() { return teamId; }
    public String getTeamName() { return teamName; }
    public int getMemberCount() { return memberCount; }
    public double getAverageWeight() { return averageWeight; }

    public void setTeamName(String teamName) { this.teamName = teamName; }
    public void setMemberCount(int memberCount) { this.memberCount = memberCount; }
    public void setAverageWeight(double averageWeight) { this.averageWeight = averageWeight; }

    public void inputData(Scanner sc) {
        System.out.print("Nhap ID: ");
        teamId = sc.nextLine();
        System.out.print("Nhap ten doi: ");
        teamName = sc.nextLine();
        System.out.print("Nhap so thanh vien: ");
        memberCount = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap can nang TB: ");
        averageWeight = Double.parseDouble(sc.nextLine());
    }

    public void displayData() {
        System.out.println("----------------------");
        System.out.println("ID: " + teamId);
        System.out.println("Ten: " + teamName);
        System.out.println("So TV: " + memberCount);
        System.out.println("Can nang TB: " + averageWeight);
    }
}