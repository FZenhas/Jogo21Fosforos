import java.util.Random;
import java.util.Scanner;

public class Main {
    static String jogador1;
    static String jogador2;
    static Scanner in = new Scanner(System.in);
    static Random rnd = new Random();


    public static void main(String[] args) {
        /*O jogo dos 21 fósforos coloca dois oponentes a retirar fósforos, à vez, até sobrar o último. Quem ficar com o último fósforo
        perde. Em cada jogada é possível retirar 1, 2, 3 ou 4 fósforos. Implemente uma aplicação que permita jogar:
        1. Dois jogadores humanos;
        2. Humano contra computador (sem inteligência);
        3. Humano contra computador (com inteligência);
         */

        System.out.println("Qual o seu nome?");
        jogador1 = in.next();

        int opcao = 1;

        while (opcao != 0) {
            System.out.println("Ola " + jogador1 + "! Bem-vindo(a) ao jogo do 21 fosforos. \nRegras: O jogo dos 21 fosforas coloca 2 openentes a retirar fosforos, alternadamente, ate sobrar o ultimo. \nQuem ficar com o ultimo fosforo perde. Em cada jogada e possivel retirar 1, 2 ,3 ou 4 fosforos.");
            System.out.println("1: Jogar contra um jogador");
            System.out.println("2: Jogar contra o computador com Inteligencia");
            System.out.println("3: Jogar contra o computador sem Intelegencia");
            System.out.println("0: Sair");
            opcao = in.nextInt();


            switch (opcao) {
                case 0:
                    System.out.println("Sair");
                    break;
                case 1:
                    JogarComJogador();
                    break;
                case 2:
                    JogarPCInteligente();
                    break;
                case 3:
                    JogarPCSemInteligencia();
                    break;
                default:
                    System.out.println("Opcao invalida");
                    break;
            }
        }
    }

    private static void JogarComJogador() {

            System.out.println("Jogar contra um jogador");
            System.out.println("Escolha a sua vez: \n1: Primeiro(a) a jogar; \n2: Segundo(a) a jogar; \n3: Escolha Aleatoria");
            System.out.println("0: Voltar ao menu");
            int opcao = in.nextInt();

            switch (opcao) {
                case 0:
                    System.out.println("Sair");
                    break;
                case 1:
                    PrimeiroJogarVsJogador();
                    break;
                case 2:
                    SegundoJogarVsJogador();
                    break;
                case 3:
                    AleatorioJvsJ();
                    break;
                default:
                    System.out.println("Opcao invalida");
            }
        }

    private static void PrimeiroJogarVsJogador() {

        System.out.println("Qual o nome do segundo jogador?");
        jogador2 = in.next();

        System.out.println("Regras: O jogo dos 21 fosforas coloca 2 openentes a retirar fosforos, alternadamente, ate sobrar o ultimo. \nQuem ficar com o ultimo fosforo perde. Em cada jogada e possivel retirar 1, 2 ,3 ou 4 fosforos.");

        JogoJogadorvsJogador(jogador1, jogador2);
    }

    private static void SegundoJogarVsJogador() {

        System.out.println("Qual o nome do segundo jogador?");
        jogador2 = in.next();

        System.out.println("");

        JogoJogadorvsJogador(jogador2, jogador1);
    }

    private static void AleatorioJvsJ() {
        int sorteio;

        System.out.println("Qual o nome do segundo jogador?");
        jogador2 = in.next();

        sorteio = rnd.nextInt(1, 3);

        if (sorteio == 1) {
            System.out.println("O primeiro a jogar e o " + jogador1);
            JogoJogadorvsJogador(jogador1, jogador2);

        } else {
            System.out.println("O primeiro a jogar e o " + jogador2);
            JogoJogadorvsJogador(jogador2, jogador1);
        }
    }

    private static void JogoJogadorvsJogador(String jogador1, String jogador2) {
        int nrFosforos = 0;
        int fosforos = 21;
        int totalFosforos = fosforos - nrFosforos;

        for (int i = 0; i < fosforos; i++) {

            if (i % 2 == 0) {
                System.out.println(jogador1 + ": Quantos fosforos quer tirar?");
            } else {
                System.out.println(jogador2 + ": Quantos fosforos quer tirar?");
            }
            nrFosforos = in.nextInt();

            if (totalFosforos - nrFosforos < 1) {
                System.out.println("O objetivo e deixar um fosforo para o adversario.");
                System.out.println("Fosforos:" + totalFosforos);
                i--;
            } else if (nrFosforos >= 1 && nrFosforos <= 4) {
                totalFosforos -= nrFosforos;
                System.out.println("Fosforos:" + totalFosforos);
            } else {
                System.out.println("Retire entre 1 a 4 fosforos");
                i--;
            }
            if (totalFosforos == 1) {
                if (i % 2 == 0) {
                    System.out.println("O vencedor e: " + jogador1);
                } else {
                    System.out.println("O vencedor e: " + jogador2);
                }
                break;
            }
        }

    }

    private static void JogarPCInteligente() {

        System.out.println("Jogar contra um computador inteligente");
        System.out.println("Escolha a sua vez: \n1: Primeiro(a) a jogar; \n2: Segundo(a) a jogar; \n3: Escolha Aleatoria");
        System.out.println("0: Voltar ao menu");
        int opcao = in.nextInt();

        switch (opcao) {
            case 0:
                System.out.println("Sair");
                break;
            case 1:
                PrimeiroJogarVsPCInt();
                break;
            case 2:
                SegundoJogarVsPCInt();
                break;
            case 3:
                AleatorioJvsPCInt();
                break;
            default:
                System.out.println("Opcao invalida");
        }
    }

    private static void PrimeiroJogarVsPCInt() {
        int nrFosforos = 0;
        int fosforos = 21;
        int totalFosforos = fosforos - nrFosforos;
        jogador2 = "Computador";

        System.out.println("Vai jogar contra o " + jogador2 + ". \nPode comecar!");

        System.out.println("");


        for (int i = 0; i < fosforos; i++) {

            if (i % 2 == 0) {
                System.out.println(jogador1 + ": Quantos fosforos quer tirar?");
                nrFosforos = in.nextInt();
            } else {
                System.out.println(jogador2 + ": Quantos fosforos quer tirar?");
                if (nrFosforos == 1) {
                    nrFosforos = 4;
                    System.out.println(nrFosforos);
                } else if (nrFosforos == 2) {
                    nrFosforos = 3;
                    System.out.println(nrFosforos);
                } else if (nrFosforos == 3) {
                    nrFosforos = 2;
                    System.out.println(nrFosforos);
                } else {
                    nrFosforos = 1;
                    System.out.println(nrFosforos);
                }
            }

            if (totalFosforos - nrFosforos < 1) {
                System.out.println("O objetivo e deixar um fosforo para o adversario.");
                System.out.println("Fosforos:" + totalFosforos);
                i--;
            } else if (nrFosforos >= 1 && nrFosforos <= 4) {
                totalFosforos -= nrFosforos;
                System.out.println("Fosforos:" + totalFosforos);
            } else {
                System.out.println("Retire entre 1 a 4 fosforos");
                i--;
            }
            if (totalFosforos == 1) {
                if (i % 2 == 0) {
                    System.out.println("O vencedor e: " + jogador1);
                } else {
                    System.out.println("O vencedor e: " + jogador2);
                }
                break;
            }
        }

    }

    private static void SegundoJogarVsPCInt() {
        Random rnd = new Random();
        int nrFosforos = 0;
        int fosforos = 21;
        int totalFosforos = fosforos - nrFosforos;

        jogador2 = "Computador";

        System.out.println("Vai jogar contra o " + jogador2 + ". \nComeca o " + jogador2 + "!");

        System.out.println();
        for (int i = 0; i < fosforos; i++) {
            int res16 = totalFosforos - 16;
            int res11 = totalFosforos - 11;
            int res6 = totalFosforos - 6;
            int res1 = totalFosforos -1;

            if (i % 2 == 0) {
                System.out.println(jogador2 + ": Quantos fosforos quer tirar?");
                if ((totalFosforos == 21) || (totalFosforos ==16) || (totalFosforos == 11) || (totalFosforos == 6)){
                    nrFosforos = rnd.nextInt(1,5);
                    System.out.println(nrFosforos);
                }
                if((totalFosforos > 16) && (totalFosforos < 21)) {
                    nrFosforos = res16;
                    System.out.println(nrFosforos);
                }
                if ((totalFosforos > 11) && (totalFosforos < 16)) {
                    nrFosforos = res11;
                    System.out.println(nrFosforos);
                }
                if ((totalFosforos > 6) && (totalFosforos < 11)) {
                    nrFosforos = res6;
                    System.out.println(nrFosforos);
                }
                if ((totalFosforos > 1) && (totalFosforos < 6)) {
                    nrFosforos = res1;
                    System.out.println(nrFosforos);
                }

            }else {
                System.out.println(jogador1 + ": Quantos fosforos quer tirar?");
                nrFosforos = in.nextInt();
            }


            if (totalFosforos - nrFosforos < 1) {
                System.out.println("O objetivo e deixar um fosforo para o adversario.");
                System.out.println("Fosforos:" + totalFosforos);
                i--;
            } else if (nrFosforos >= 1 && nrFosforos <= 4) {
                totalFosforos -= nrFosforos;
                System.out.println("Fosforos:" + totalFosforos);
            } else {
                System.out.println("Retire entre 1 a 4 fosforos");
                i--;
            }
            if (totalFosforos == 1) {
                if (i % 2 == 0) {
                    System.out.println("O vencedor e: " + jogador2);
                } else {
                    System.out.println("O vencedor e: " + jogador1);
                }
                break;
            }
        }
    }


    private static void AleatorioJvsPCInt () {
        Random rnd = new Random();
        int sorteio;
        jogador2 = "Computador";

        sorteio = rnd.nextInt(1, 3);

        if (sorteio == 1) {
            PrimeiroJogarVsPCInt();
        } else {
            SegundoJogarVsPCInt();
        }
    }

    private static void JogarPCSemInteligencia() {

            System.out.println("Jogar contra um computador sem inteligencia");
            System.out.println("Escolha a sua vez: \n1: Primeiro(a) a jogar; \n2: Segundo(a) a jogar; \n3: Escolha Aleatoria");
            System.out.println("0: Voltar ao menu");
            int opcao = in.nextInt();

            switch (opcao) {
                case 0:
                    System.out.println("Sair");
                    break;
                case 1:
                    PrimeiroJogarVsPCsemInt();
                    break;
                case 2:
                    SegundoJogarVsPCsemInt();
                    break;
                case 3:
                    AleatorioJvsPCsemInt();
                    break;
                default:
                    System.out.println("Opcao invalida");
            }
        }

    private static void PrimeiroJogarVsPCsemInt() {
        Random rnd = new Random();

        int nrFosforos = 0;
        int fosforos = 21;
        int totalFosforos = fosforos - nrFosforos;
        jogador2 = "Computador";

        System.out.println("Vai jogar contra o " + jogador2 + ". \nPode comecar!");

        System.out.println("");

        for (int i = 0; i < fosforos; i++) {

            if (i % 2 == 0) {
                System.out.println(jogador1 + ": Quantos fosforos quer tirar?");
                nrFosforos = in.nextInt();
            } else {
                System.out.println(jogador2 + ": Quantos fosforos quer tirar?");
                nrFosforos = rnd.nextInt(1, 5);
                System.out.println(nrFosforos);
            }


            if (totalFosforos - nrFosforos < 1) {
                System.out.println("O objetivo e deixar um fosforo para o adversario.");
                System.out.println("Fosforos:" + totalFosforos);
                i--;
            } else if (nrFosforos >= 1 && nrFosforos <= 4) {
                totalFosforos -= nrFosforos;
                System.out.println("Fosforos:" + totalFosforos);
            } else {
                System.out.println("Retire entre 1 a 4 fosforos");
                i--;
            }

            if (totalFosforos == 1) {
                if (i % 2 == 0) {
                    System.out.println("O vencedor e: " + jogador1);
                } else {
                    System.out.println("O vencedor e: " + jogador2);
                }
                break;
            }
        }
    }

    private static void SegundoJogarVsPCsemInt() {
        Random rnd = new Random();

        jogador2 = "Computador";
        int nrFosforos = 0;
        int fosforos = 21;
        int totalFosforos = fosforos - nrFosforos;


        System.out.println("Vai jogar contra o " + jogador2 + ". \nComeca o " + jogador2 + "!");

        System.out.println();

        for (int i = 0; i < fosforos; i++) {

            if (i % 2 == 0) {
                System.out.println(jogador2 + ": Quantos fosforos quer tirar?");
                nrFosforos = rnd.nextInt(1, 5);
                System.out.println(nrFosforos);

            } else {
                System.out.println(jogador1 + ": Quantos fosforos quer tirar?");
                nrFosforos = in.nextInt();
            }

            if (totalFosforos - nrFosforos < 1) {
                System.out.println("O objetivo e deixar um fosforo para o adversario e ganhar");
                System.out.println("Fosforos:" + totalFosforos);
                i--;
            } else if (nrFosforos >= 1 && nrFosforos <= 4) {
                totalFosforos -= nrFosforos;
                System.out.println("Fosforos:" + totalFosforos);
            } else {
                System.out.println("Retire entre 1 a 4 fosforos");
                i--;
            }

            if (totalFosforos == 1) {
                if (i % 2 == 0) {
                    System.out.println("O vencedor e: " + jogador2);
                } else {
                    System.out.println("O vencedor e: " + jogador1);
                }
                break;
            }
        }
    }

    private static void AleatorioJvsPCsemInt() {
        Random rnd = new Random();
        int sorteio;
        jogador2 = "Computador";

        sorteio = rnd.nextInt(1, 3);

        if (sorteio == 1) {
            PrimeiroJogarVsPCsemInt();
        } else {
            SegundoJogarVsPCsemInt();
        }
    }
}

