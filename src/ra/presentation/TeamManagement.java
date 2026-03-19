package ra.presentation;

import ra.business.TeamBusiness;
import ra.entity.Team;

import java.util.Scanner;

public class TeamManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TeamBusiness business = TeamBusiness.getInstance();
        int choice;

        do {
            System.out.println("\n====== QUAN LY DOI ======");
            System.out.println("1. Hien thi danh sach");
            System.out.println("2. Them doi");
            System.out.println("3. Cap nhat doi");
            System.out.println("4. Xoa doi");
            System.out.println("5. Tim theo ten");
            System.out.println("6. Tim vo dich");
            System.out.println("7. Sap xep giam dan");
            System.out.println("8. Thoat");
            System.out.print("Chon: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    business.displayTeamList();
                    break;
                case 2:
                    Team team = new Team();
                    team.inputData(sc);
                    business.addTeam(team);
                    break;
                case 3:
                    System.out.print("Nhap ID can cap nhat: ");
                    business.updateTeam(sc.nextLine(), sc);
                    break;
                case 4:
                    System.out.print("Nhap ID can xoa: ");
                    business.deleteTeam(sc.nextLine());
                    break;
                case 5:
                    System.out.print("Nhap ten can tim: ");
                    business.findByName(sc.nextLine());
                    break;
                case 6:
                    business.findChampion();
                    break;
                case 7:
                    business.sortDesc();
                    business.displayTeamList();
                    break;
                case 8:
                    System.out.println("Thoat!");
                    break;
                default:
                    System.out.println("Sai lua chon!");
            }
        } while (choice != 8);
    }
}