import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Random;

public class GeradorFigurinhas {

    public void CriarFigurinha (InputStream urlImg,String nomeArquivo) throws Exception {

        //leitura da iimagem
            // leitura da imagem em pasta
            //InputStream inputStream = new FileInputStream(new File("image/nomeImagem"));
        //leitura da url da imagem
        //InputStream urlImg = new URL(urlImagem).openStream();
       BufferedImage imgOriginal =  ImageIO.read(urlImg);
        //criar nova imagem em memória com transparência e com tamanho novo
        int imgWidth = imgOriginal.getWidth();
        int imgHeight = imgOriginal.getHeight();
        int newImgHeight = imgHeight + 200;
        BufferedImage newImg = new BufferedImage(imgWidth, newImgHeight, BufferedImage.TRANSLUCENT);

        //copiar a imaem original para novo (em memória)
        Graphics2D graphics = (Graphics2D) newImg.getGraphics();
        graphics.drawImage(imgOriginal, 0, 0, null);

        //Configurar Fonte
        var fonte = new Font(Font.SANS_SERIF,Font.BOLD, 90 );
        graphics.setFont(fonte);
        graphics.setColor(Color.cyan);
        //escrever uma frase na nova imagem
        graphics.drawString("TOP",imgWidth-650,newImgHeight -100);
        // escrever a nova imagem em um arquivo
        Random numberRandom = new Random();
        ImageIO.write(newImg, "png", new File("image/figurinha/"+nomeArquivo));
    }
}
