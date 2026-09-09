import java.util.Scanner;

import Equipe.MenuEquipe;
import Equipe.PersistenciaFuncionario;

import Frota.MenuFrota;
import Frota.PersistenciaFrota;

import Registros.MenuRegistro;
import Registros.PersistenciaRegistros;

import Relatorios.MenuRelatorios;

import Talhoes.menuTalhao;
import Talhoes.persistenciaTalhao;

public class SistemaPrincipal {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        PersistenciaRegistros.carregarRegistrosCSV();

        persistenciaTalhao.carregarTalhoes();

        PersistenciaFuncionario.carregarFuncionariosCSV();

        PersistenciaFrota.carregarFrotaCSV();

        int opcao;

        do {

            System.out.println("\n===== SISTEMA FAZENDA =====");

            System.out.println("1 - Talhões");
            System.out.println("2 - Funcionários");
            System.out.println("3 - Frota");
            System.out.println("4 - Colheita");
            System.out.println("5 - Mercado do Café");
            System.out.println("6 - Relatórios");
            System.out.println("0 - Sair");

            System.out.print("Opção: ");

            opcao = sc.nextInt();

            sc.nextLine();

            switch (opcao) {

                case 1:

                    menuTalhao.abrirMenuTalhao();
                    break;

                case 2:

                    MenuEquipe.abrirMenuEquipe();
                    break;

                case 3:

                    MenuFrota.abrirMenuFrota();
                    break;

                case 4:

                    MenuRegistro.abrirMenuRegistro();
                    break;

                case 5:

                    MercadoCafe.abrirMenuMercado();
                    break;
                case 6:

                    MenuRelatorios.abrirMenuRelatorios();
                    break;

                case 0:

                    System.out.println("Sistema encerrado.");
                    break;

                default:

                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }
}