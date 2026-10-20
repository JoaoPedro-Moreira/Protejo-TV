import java.util.Scanner;


public class Main
{
    static void exibirMenu(){
        System.out.println("SELECIONE UMA DAS OPCOES");
        System.out.println();
        System.out.println("[1] - LIGAR / DESLIGAR");
        System.out.println("[2] - AUMENTAR VOLUME");
        System.out.println("[3] - DIMINUIR VOLUME");
        System.out.println("[4] - TROCAR CANAL");
        System.out.println("[0] - ENCERRAR");
        System.out.println();
        System.out.println("Digite a opção desejada: ");
    }

    static void exibirEstadoAtualTV(TV tvSelecionada){

        System.out.println("ESTADO ATUAL DA TV");
        System.out.println("====================");

        if (tvSelecionada.status==0){
            System.out.println("STATUS: Desligada");
        }else{
            System.out.println("STATUS: Ligada");
        }

        System.out.println("VOLUME: " + tvSelecionada.volume);
        System.out.println("CANAL: " + tvSelecionada.canal);
        System.out.println("====================");
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int opcao, novoCanal, resultado;
        int tvEscolhida;

        TV tvSala, tvQuarto, tvSelecionada=null;

        tvSala = new TV();
        tvQuarto = new TV();


        do {
            System.out.println("Qual TV deseja controlar?");
            System.out.println("1 - TV da sala");
            System.out.println("2 - TV do quarto");
            System.out.println("9 - Encerrar");
            System.out.print("Escolha: ");
            tvEscolhida = teclado.nextInt();

            if (tvEscolhida != 1 && tvEscolhida != 2 && tvEscolhida != 9){
                System.out.println("TV inválida");
            } else {
                if (tvEscolhida == 9) {
                    System.out.println("Encerrando...");
                } else {
                    if (tvEscolhida == 1) {
                        tvSelecionada = tvSala;
                        System.out.println("TV Selecionada: SALA\n");
                    } else {
                        tvSelecionada = tvQuarto;
                        System.out.println("TV Selecionada: QUARTO\n");
                    }

                    do {
                        exibirEstadoAtualTV(tvSelecionada);

                        System.out.println("\nCONTROLE DAS TVs");
                        System.out.println("1 - Ligar ou desligar");
                        System.out.println("2 - Trocar de canal");
                        System.out.println("3 - Aumentar o volume");
                        System.out.println("4 - Diminuir o volume");
                        System.out.println("0 - Encerrar");
                        System.out.print("Escolha uma opção: ");
                        opcao = teclado.nextInt();

                        switch (opcao) {
                            case 1:
                                tvSelecionada.ligar_desligar();
                                break;

                            case 2:
                                System.out.print("Informe o canal (1, 3, 5, 7 ou 11): ");
                                novoCanal = teclado.nextInt();

                                resultado = tvSelecionada.trocar_canal(novoCanal);

                                if (resultado == -1) {
                                    System.out.println("Não é possível trocar o canal: a TV está desligada");
                                } else {
                                    if (resultado == -2) {
                                        System.out.println("Canal inválido");
                                    } else {
                                        System.out.println("Canal alterado para " + resultado);
                                    }
                                }
                                break;

                            case 3:
                                tvSelecionada.aumentar_volume();
                                break;

                            case 4:
                                tvSelecionada.diminuir_volume();
                                break;

                            case 0:
                                if (tvEscolhida == 1) {
                                    System.out.println("Finalizando o uso da TV da sala");
                                } else {
                                    System.out.println("Finalizando o uso da TV do quanto");
                                }
                                break;

                            default:
                                System.out.println("Opção inválida");
                        }

                    } while (opcao != 0);
                }
            }
        }while (tvEscolhida != 9);
    }
}

