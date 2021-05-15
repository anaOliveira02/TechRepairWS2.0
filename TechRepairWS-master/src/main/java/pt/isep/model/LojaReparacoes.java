package pt.isep.model;

import pt.isep.exception.ElementoNaoExistenteException;
import pt.isep.exception.TecnicoExistenteException;
import pt.isep.model.Tecnico;

import java.io.Serializable;
import java.util.ArrayList;

public class LojaReparacoes implements Serializable {

    private ArrayList<Tecnico> tecnicos = new ArrayList<>();
/*    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Assistencia> assistencias = new ArrayList<>();
    private ArrayList<Orcamento> orcamentos = new ArrayList<>();*/

    public void adicionarTecnico(Tecnico novo){
        for (int i = 0; i < tecnicos.size(); i++) {
            Tecnico actual = tecnicos.get(i);
            if(novo.getNumTec() == actual.getNumTec()){
                throw new TecnicoExistenteException("individuo já existe");
            }
        }
        tecnicos.add(novo);
    }

    public Tecnico getByNumTec(int numTec) {
        for (int i = 0; i < tecnicos.size(); i++) {
            Tecnico p = tecnicos.get(i);
            if (p.getNumTec() == numTec) {
                return new Tecnico((Tecnico) p);
            } else {
                return new Tecnico(p);
            }
        }
        return null;
    }


    public Tecnico removeTecnicoNumTec(int numTec) {
        Tecnico tecnico = getByNumTec(numTec);
        if (tecnico != null) {
            tecnicos.remove(tecnico);
            return tecnico;
        }
        return null;
    }

    public ArrayList<Tecnico> getTecnicos() {
        ArrayList<Tecnico> tecnicos = new ArrayList<>();
        for (int i = 0; i < this.tecnicos.size(); i++) {
            Tecnico p = this.tecnicos.get(i);
            tecnicos.add(new Tecnico( p ));
        }
        return tecnicos;
    }
}
