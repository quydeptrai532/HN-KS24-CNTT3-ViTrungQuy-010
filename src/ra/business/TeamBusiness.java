package ra.business;

import ra.entity.Team;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeamBusiness {
    private static TeamBusiness instance;
    private List<Team> teamList;

    private TeamBusiness() {
        teamList = new ArrayList<>();
    }

    public static TeamBusiness getInstance() {
        if (instance == null) {
            instance = new TeamBusiness();
        }
        return instance;
    }

    public void displayTeamList() {
        if (teamList.isEmpty()) {
            System.out.println("Danh sach rong");
            return;
        }
        for (Team t : teamList) {
            t.displayData();
        }
    }

    public void addTeam(Team team) {
        teamList.add(team);
        System.out.println("Them thanh cong!");
    }

    public void updateTeam(String id, Scanner sc) {
        for (Team t : teamList) {
            if (t.getTeamId().equalsIgnoreCase(id)) {
                System.out.println("Nhap thong tin moi:");

                System.out.print("Ten moi: ");
                t.setTeamName(sc.nextLine());

                System.out.print("So TV moi: ");
                t.setMemberCount(Integer.parseInt(sc.nextLine()));

                System.out.print("Can nang TB moi: ");
                t.setAverageWeight(Double.parseDouble(sc.nextLine()));

                System.out.println("Cap nhat thanh cong!");
                return;
            }
        }
        System.out.println("Khong tim thay team!");
    }

    public void deleteTeam(String idDelete){
        int oldSize = teamList.size();

        teamList.removeIf(team -> team.getTeamId().equalsIgnoreCase(idDelete));

        int newSize = teamList.size();

        if(oldSize == newSize){
            System.out.println("Khong tim thay doi co id can xoa");
        } else {
            System.out.println("Xoa thanh cong");
        }
    }

    public void findByName(String name) {
        boolean found = false;
        for (Team t : teamList) {
            if (t.getTeamName().equalsIgnoreCase(name)) {
                t.displayData();
                found = true;
            }
        }
        if (!found) System.out.println("Khong tim thay");
    }

    public void findChampion() {
        if (teamList.isEmpty()) return;

        double max = teamList.get(0).getAverageWeight();
        for (Team t : teamList) {
            if (t.getAverageWeight() > max) max = t.getAverageWeight();
        }

        System.out.println("Doi vo dich:");
        for (Team t : teamList) {
            if (t.getAverageWeight() == max) {
                t.displayData();
            }
        }
    }

    public void sortDesc() {
        teamList.sort((a, b) -> Double.compare(b.getAverageWeight(), a.getAverageWeight()));
        System.out.println("Da sap xep!");
    }
}