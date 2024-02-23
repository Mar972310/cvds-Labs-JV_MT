package hangman.model.Implementation;

public class OriginalScore implements GameScore{

    /**
     * Este metodo calcula si el puntaje de acuerdo con las letras correctas e incorrectas.
     *
     * @pre Inicia con 100 puntos.
     * @post El puntaje minimo es 0.
     * @param correctCount Cantidad de letras acertadas.
     * @param incorrectCount Cantidad de letras incorrectas.
     * @return retorna un entero con el puntaje obtenido y la pelanización de 10 puntos por letra incorrecta.
     */
    public int calculateScore(int correctCount, int incorrectCount){

        int score = 100 - incorrectCount * 10;
        if (score < 0){
            score = 0;
        }
        return score;
    }
}
