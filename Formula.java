
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Formula {
    
    //==== Geometria Básica ====

        // Área Quadrado
        public static BigDecimal areaQuadrado(BigDecimal lado) {
            BigDecimal resultado = lado.pow(2);
            return resultado.setScale(2, RoundingMode.HALF_UP);
        }

        // Área Retângulo
        public static BigDecimal areaRetangulo(BigDecimal lado, BigDecimal altura) {
            BigDecimal resultado = lado.multiply(altura);
            return resultado.setScale(2, RoundingMode.HALF_UP);
        }

        // Área Triângulo
        public static BigDecimal areaTriangulo(BigDecimal base, BigDecimal altura) {
            BigDecimal resultado = (base.multiply(altura)).divide(new BigDecimal(2));
            return resultado.setScale(2, RoundingMode.HALF_UP);
        }

        // Área Círculo
        public static BigDecimal areaCirculo(BigDecimal raio) {
            BigDecimal resultado = (raio.pow(2)).multiply(new BigDecimal(3.14));
            return resultado.setScale(2, RoundingMode.HALF_UP);
        }

        // Circunferência Círculo
        public static BigDecimal circunferenciaCirculo(BigDecimal raio) {
            BigDecimal resultado = (new BigDecimal(3.14).multiply(new BigDecimal(2))).multiply(raio);
            return resultado.setScale(2, RoundingMode.HALF_UP);
        }

    //==== Geometria Espacial ====

        // Volume Cubo
        public static BigDecimal volumeCubo(BigDecimal lado) {
            BigDecimal resultado = lado.pow(3);
            return resultado.setScale(2, RoundingMode.HALF_UP);
        }

        // Volume Paralelepípedo
        public static BigDecimal volumeParalelepipedo(BigDecimal arestaX, BigDecimal arestaY, BigDecimal arestaZ) {
            BigDecimal resultado = (arestaX.multiply(arestaY)).multiply(arestaZ);
            return resultado.setScale(2, RoundingMode.HALF_UP);
        }

        // Volume Esfera
        public static BigDecimal volumeEsfera(BigDecimal raio) {
            BigDecimal resultado = (new BigDecimal(1.33).multiply(new BigDecimal(3.14))).multiply(raio.pow(3));
            return resultado.setScale(2, RoundingMode.HALF_UP);
        }

        // Volume Cilindro
        public static BigDecimal volumeCilindro(BigDecimal raio, BigDecimal altura) {
            BigDecimal resultado = (raio.pow(2)).multiply(new BigDecimal(3.14)).multiply(altura);
            return resultado.setScale(2, RoundingMode.HALF_UP);
        }

        // Volume Pirâmide
        public static BigDecimal volumePiramide(BigDecimal arestaXBase, BigDecimal arestaYBase, BigDecimal altura) {
            BigDecimal divisor2 = new BigDecimal(2); BigDecimal divisor3 = new BigDecimal(3);
            BigDecimal areaBase = (arestaXBase.multiply(arestaYBase)).divide(divisor2, 10, RoundingMode.HALF_UP);
            BigDecimal resultado = ((areaBase.multiply(altura)).divide(divisor3, 10, RoundingMode.HALF_UP));
            return resultado.setScale(2, RoundingMode.HALF_UP);
        }


    //==== Financeiro ====

        // Porcentagem
        public static BigDecimal porcentagem(BigDecimal valorTotal, BigDecimal percentual) {
            BigDecimal resultado = (valorTotal.multiply(percentual)).divide(new BigDecimal(100.0), 10, RoundingMode.HALF_UP);
            return resultado.setScale(2, RoundingMode.HALF_UP);
        }

        // Juros Simples
        public static BigDecimal jurosSimples(BigDecimal capitalInicial, BigDecimal taxaDeJurosEmPorcentagem, BigDecimal tempo) {
            BigDecimal taxaDeJuros = taxaDeJurosEmPorcentagem.divide(new BigDecimal(100), 10, RoundingMode.HALF_UP);
            BigDecimal resultado = (capitalInicial.multiply(taxaDeJuros)).multiply(tempo);
            return resultado.setScale(2, RoundingMode.HALF_UP);
        }

        // Montante Juros Simples
        public static BigDecimal montanteJurosSimples(BigDecimal capitalInicial, BigDecimal taxaDeJurosEmPorcentagem, BigDecimal tempo) {
            BigDecimal taxaDeJuros = taxaDeJurosEmPorcentagem.divide(new BigDecimal(100), 10, RoundingMode.HALF_UP);
            BigDecimal juros = taxaDeJuros.multiply(tempo);
            BigDecimal resultado = capitalInicial.multiply(new BigDecimal(1).add(juros));
            return resultado.setScale(2, RoundingMode.HALF_UP);
        }

        // Juros Compostos
        public static BigDecimal jurosCompostos(BigDecimal capitalInicial, BigDecimal taxaDeJurosEmPorcentagem, BigDecimal tempo) {
            BigDecimal taxaDeJuros = taxaDeJurosEmPorcentagem.divide(new BigDecimal(100), 10, RoundingMode.HALF_UP);
            BigDecimal taxaDeJurosNaFormula = (taxaDeJuros.add(new BigDecimal(1))).pow(Integer.parseInt(tempo.toString()));
            BigDecimal resultado = (capitalInicial.multiply(taxaDeJurosNaFormula.subtract(new BigDecimal(1))));
            return resultado.setScale(2, RoundingMode.HALF_UP);
        }

        // Montante Juros Compostos
        public static BigDecimal montanteJurosCompostos(BigDecimal capitalInicial, BigDecimal taxaDeJurosEmPorcentagem, BigDecimal tempo) {
            BigDecimal taxaDeJuros = taxaDeJurosEmPorcentagem.divide(new BigDecimal(100), 10, RoundingMode.HALF_UP);
            BigDecimal resultado = (capitalInicial.multiply((taxaDeJuros.add(new BigDecimal(1))).pow(Integer.parseInt(tempo.toString()))));
            return resultado.setScale(2, RoundingMode.HALF_UP);
        }
}
