package firstAdventure.base;

import javazoom.jl.player.Player;
import lombok.extern.slf4j.Slf4j;


import java.io.InputStream;
import java.util.Scanner;

@Slf4j
public class AudioPlayer {


    private static final String MUSICA_CALMARIA_NA_VILA =  "musicas/fantasy-medieval-ambient-237371.mp3";
    private static final String MUSICA_MISTERIOSA =  "musicas/fantasy-medieval-epic-music-239599.mp3";
    private static final String MUSICA_CREDITOS =  "musicas/medieval-adventure-154671.mp3";
    private static final String AUDIO_ACAO_VOLUME_ALTO =  "musicas/medieval-adventure-270566.mp3";
    private static final String MUSICA_CRIACAO_PERSONAGEM =  "musicas/medieval-ambient-236809.mp3";
    private static final String AUDIO_INICIO_VOLUME_ALTO =  "musicas/medieval-background-196571.mp3";
    private static final String AUDIO_ACAO_VILA_VOLUME_ALTO =  "musicas/medieval-opener-270568.mp3";
    private static final String MUSICA_INICIO =  "musicas/medieval-star-188280.mp3";


    private static Player player;
    private static Thread musicThread;
    private static boolean tocando = false;

    private static void tocarMusica(String musicaSelecionada) {
        pararMusica(); // Para qualquer música antes de tocar a nova
        tocando = true;
        musicThread = new Thread(() -> {
            while (tocando) { // Continua tocando até que seja solicitado parar
                try {
                    // Carregar o arquivo MP3 do classpath
                    InputStream audioStream = AudioPlayer.class.getClassLoader().getResourceAsStream(musicaSelecionada);
                    if (audioStream == null) {
                        throw new RuntimeException("Arquivo de música não encontrado!");
                    }

                    player = new Player(audioStream); // Criar player
                    player.play(); // Tocar música (bloqueia até acabar)

                } catch (Exception e) {
                    log.info("Teste", e);
                }
            }
        });

        musicThread.start(); // Iniciar a thread da música
    }

    public static void pararMusica() {
        tocando = false; // Faz o loop da música parar
        if (player != null) {
            player.close(); // Interrompe a música
        }
        if (musicThread != null) {
            musicThread.interrupt(); // Para a thread da música
        }
    }

    public static void tocarMusicaCalmaDeVila() {
        tocarMusica(MUSICA_CALMARIA_NA_VILA);
    }

    public static void tocarMusicaMisteriosa() {
        tocarMusica(MUSICA_MISTERIOSA);
    }

    public static void tocarMusicaCreditos() {
        tocarMusica(MUSICA_CREDITOS);
    }

    public static void tocarMusicaCriacaoPersonagem() {
        tocarMusica(MUSICA_CRIACAO_PERSONAGEM);
    }

    public static void tocarMusicaInicio() {
        tocarMusica(MUSICA_INICIO);
    }

//    public static void testarMusicTeste() {
//        try {
//            // Carregar o arquivo MP3 do classpath
//            InputStream audioStream = AudioPlayer.class.getClassLoader().getResourceAsStream(TESTE);
//            if (audioStream == null) {
//                throw new RuntimeException("Arquivo de música não encontrado!");
//            }
//
//            player = new Player(audioStream); // Criar player
//            player.play(); // Tocar música (bloqueia até acabar)
//        } catch (Exception e) {
//            log.info("Teste", e);
//        }
//    }


//    public static void main(String[] args) {
//        tocarMusicaInicio();
//        Thread thread = new Thread(AudioPlayer::testarMusicTeste);
//        thread.start();
//        System.out.println("O jogo está rodando enquanto a música toca...");
//        Scanner scan = new Scanner(System.in);
//        scan.nextLine();
//        pararMusica();
//    }

    }
