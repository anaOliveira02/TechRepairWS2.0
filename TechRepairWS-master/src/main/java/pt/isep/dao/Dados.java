package pt.isep.dao;

import pt.isep.model.LojaReparacoes;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.CREATE;

public class Dados {
    static final String DRS_FILE ="techrepair_dados.dat";

    public static LojaReparacoes carregarDados(){
        LojaReparacoes lojaReparacoes = new LojaReparacoes();
        Path file = Paths.get(DRS_FILE);
        try {
            ObjectInputStream o = new ObjectInputStream(new FileInputStream(file.toString()));
            lojaReparacoes = (LojaReparacoes) o.readObject();
            o.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return lojaReparacoes;
    }

    public static void guardarDados(LojaReparacoes trackingCovid) {
        Path file = Paths.get(DRS_FILE);
        try{
            ObjectOutputStream o = new ObjectOutputStream(Files.newOutputStream(file, CREATE));
            o.writeObject(trackingCovid);
            o.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
