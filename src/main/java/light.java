/*
    Natthawee   Koengfak          6213125
    Wasawat     Pengprakhon       6213132
    Nicharee    Chalermsuksri     6213198
    Puwich      Rotchanakanokchok 6213209
 */
import java.util.*;
import java.util.Random;

public class light {

    public static void main(String[] args) {
        int size = 0;
        int n = 0;
        int area = 0;
        String problem = null;
        boolean input_err = true;
        boolean repeat = true;
        Scanner input = null;
        
        while (repeat) {
            input_err = true;
            problem = null;
            System.out.println("==========================Input puzzle data============================");
            while (input_err) {
                try {
                    System.out.println("Input puzzle size(N):");
                    input = new Scanner(System.in);
                    size = input.nextInt();
                    area = size * size;
                    if (size < 3) {
                        System.out.println("************************* !!! WARNING !!! *************************");
                        System.out.println("         Size of puzzle must be more than 3, please try again.        ");
                        System.out.println("*******************************************************************\n");
                    } else {
                        input_err = false;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("*************************** !!! WARNING !!! ***************************");
                    System.out.println("                 Type of input error (Integer only) or");
                    System.out.println("            A number is out of range(3,2147483647)");
                    System.out.println("                           Please try again. ");
                    System.out.println("***********************************************************************\n");
                    input_err = true;
                } catch (NumberFormatException e) {
                    System.out.println("*************************** !!! WARNING !!! ***************************");
                    System.out.println("                 Type of input error (Integer only) or");
                    System.out.println("            A number is out of range(3,2147483647)");
                    System.out.println("                           Please try again. ");
                    System.out.println("***********************************************************************\n");
                    input.reset();
                }
            }

            input_err = true;
            while (input_err) {
                try {
                    System.out.printf("Input puzzle states (%d bits, left to right,line by line):\n", area);
                    input = new Scanner(System.in);
                    problem = input.nextLine();
                    boolean check = true;
                    for (int i = 0; i < problem.length(); i++) {
                        if (Integer.parseInt(String.valueOf(problem.charAt(i))) > 1) {
                            System.out.println("Invalid state input!, please input only 0 or 1");
                            System.out.println("************************* !!! WARNING !!! *************************");
                            System.out.println("                 Type of input error (Integer only) or");
                            System.out.println("                 A number of input must be only 0 or 1");
                            System.out.println("                           Please try again. ");
                            System.out.println("*******************************************************************\n");
                            check = false;
                            break;
                        }
                    }
                    if (problem.length() == area && check) {
                        input_err = false;
                    } else if (check) {
                        System.out.println("*************************** !!! WARNING !!! ***************************");
                        System.out.printf("              Invalid state input!, please input %d bits\n", area);
                        System.out.println("***********************************************************************\n");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid state input!, please input only 0 or 1");
                    System.out.println("*************************** !!! WARNING !!! ***************************");
                    System.out.println("                 Type of input error (Integer only) or");
                    System.out.println("                 A number of input must be only 0 or 1");
                    System.out.println("                           Please try again. ");
                    System.out.println("***********************************************************************\n");
                    input_err = true;
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("*************************** !!! WARNING !!! ***************************");
                    System.out.printf("              Invalid state input!, please input %d bits\n", area);
                    System.out.println("***********************************************************************\n");
                    input_err = true;
                }
            }

            lightSolver lightout = new lightSolver(problem,size);
            lightout.printLayout();
            System.out.println("============================Puzzle board===============================");
            System.out.println("Puzzle problem: ");
            lightout.printBoard(problem);
            if(lightout.getstartState().hashCode()==-1){
                System.out.println("*************************** !!! WARNING !!! ***************************");
                System.out.println("             Bit string is too long to convert into deccimal           ");
                System.out.println("                   Can't find solution of this size                    ");
                System.out.println("***********************************************************************\n");
            }else{
                lightout.printSolution(lightout.Solve());
            }
            boolean check_repeat = true;
            String rp;
            while (check_repeat) {
                System.out.println("Do you want to repeat ? (Y/N)");
                input = new Scanner(System.in);
                rp = input.nextLine();
                if (rp.equalsIgnoreCase("Y")) {
                    check_repeat = false;
                } else if (rp.equalsIgnoreCase("N")) {
                    repeat = false;
                    check_repeat = false;
                } else {
                    System.out.println("Invalid input!, Y to repeat or N to quit program");
                }
            }
        }
    }

}
