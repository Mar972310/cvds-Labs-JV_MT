package hangman.model.Implementation;
import java.lang.Math;
public class PowerScore implements GameScore{

    /**
     * Este metodo calcula si el puntaje de acuerdo con las letras correctas e incorrectas.
     *
     * @pre Inicia con 0 puntos.
     * @post El puntaje maximo es 500 puntos, si sobrepasa sera 500 punto igualmente.
     * @param correctCount Cantidad de letras acertadas .
     * @param incorrectCount Cantidad de letras incorrectas.
     * @return retorna un entero con el puntaje obtenido y La $i-ésima$ letra correcta se bonifica con $5^i$ y
     * y penalización de 8 puntos por cada letra incorrecta.
     */
    public int calculateScore(int correctCount, int incorrectCount){
        
        int score = 0;
        for (int i = 1; i<correctCount+1; i++){
            score += (int) Math.pow(5, i);
        }
        int result = score - 8 * incorrectCount;
        if (result < 0){
            result = 0;
        } else if (result > 500) {
            result = 500;
        }
        return result;
    }
    
}
