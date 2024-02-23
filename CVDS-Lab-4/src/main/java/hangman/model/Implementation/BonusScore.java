package hangman.model.Implementation;

public class BonusScore implements GameScore{
    /**
     * Este metodo calcula si el puntaje de acuerdo con las letras correctas e incorrectas.
     *
     * @pre Inicia con 0 puntos.
     * @post El puntaje minimo es 0
     * @param correctCount Cantidad de letras acertadas .
     * @param incorrectCount Cantidad de letras incorrectas.
     * @return retorna un entero con el puntaje obtenido, la pelanización de 5 puntos por letra incorrecta y
     * por una bonificación de 10 puntos por letra correcta.
     */
    public int calculateScore(int correctCount, int incorrectCount){
        int score = correctCount * 10 - incorrectCount * 5;
        if (score < 0){
            score = 0;
        }
        return score;
    }

}
