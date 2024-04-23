package co.edu.uptc.queueProject.services;

import java.util.List;
import java.util.LinkedList;
import co.edu.uptc.queueProject.models.Claim;

public class ClaimService {

    private LinkedList<Claim> claims = new LinkedList<Claim>();

    private int lastTurn = 0;

    public ClaimService() {
        loadDates();
    }

    public List<Claim> loadDates() {
        Claim claim = new Claim();
        claim.setName("Max Holloway");
        claim.setId("1045678943");
        claim.setAccountNumber("37589324");
        claim.setMatter("Reclamo");
        claim.setEmail("max@gmail.com");
        claim.setClaim("Quisiera expresar mi preocupación con respecto a un reciente problema que he experimentado con su servicio bancario. El mes pasado, realicé una transferencia electrónica a través de su plataforma en línea y, para mi sorpresa, el dinero aún no ha llegado al destinatario. He intentado comunicarme con su servicio de atención al cliente en varias ocasiones, pero lamentablemente no he recibido una respuesta satisfactoria ni una solución clara al problema. Esta falta de respuesta ha generado una gran frustración y ha afectado mi confianza en la confiabilidad de sus servicios. Como cliente fiel durante varios años, espero que tomen medidas rápidas para investigar y resolver esta situación de manera efectiva. Solicito una compensación adecuada por el inconveniente causado y, lo más importante, una explicación clara sobre por qué ocurrió este retraso y qué medidas están tomando para prevenir problemas similares en el futuro spero que tomen este asunto en serio y tomen medidas para restaurar mi confianza en su institución bancaria.");

        claims.add(claim);

        claim = new Claim();
        claim.setName("Juan Perez");
        claim.setId("123654789");
        claim.setAccountNumber("65890123");
        claim.setEmail("juanito@outlook.com");
        claim.setMatter("Queja");
        claim.setClaim(  "Me dirijo a ustedes para expresar mi profunda insatisfacción con el servicio que he recibido de su banco en los últimos meses. Recientemente, me encontré con varios problemas al intentar realizar transacciones simples a través de su aplicación móvil. En primer lugar, he experimentado frecuentes errores al intentar iniciar sesión en mi cuenta. A pesar de ingresar la información correcta, el sistema me ha denegado el acceso en múltiples ocasiones, lo que ha sido extremadamente frustrante y ha provocado retrasos en mis actividades financieras.Además, he notado que la aplicación carece de ciertas funciones que son estándar en otras plataformas bancarias. Por ejemplo, no puedo programar transferencias automáticas ni establecer alertas personalizadas para actividades importantes en mi cuenta.");
                
        
                
                
        claims.add(claim);

        claim = new Claim();
        claim.setName("Conor Mcregor");
        claim.setId("1045678321");
        claim.setAccountNumber("09834782");
        claim.setEmail("notoriousBig@outlook.com");
        claim.setMatter("Peticion");
        claim.setClaim("Me gustaría aprovechar esta oportunidad para presentar una solicitud importante con respecto a los servicios que ofrece su banco. Como cliente habitual, he estado utilizando su plataforma en línea durante varios años y he apreciado muchas de sus características.\n" + //
                "\n" + //
                "Sin embargo, me gustaría sugerir la implementación de una función adicional que considero beneficiosa tanto para los clientes como para la eficiencia del servicio bancario en general. Sería de gran utilidad contar con la capacidad de programar transferencias automáticas de fondos a cuentas externas de manera recurrente.\n" + //
                "\n" + //
                "Esta función sería especialmente útil para aquellos clientes que necesitan realizar pagos regulares, como facturas de servicios públicos, alquileres o contribuciones a fondos de ahorro. Al permitirnos programar estas transferencias de manera anticipada y periódica, se simplificaría considerablemente la gestión de nuestras finanzas y se reduciría el riesgo de olvidar realizar un pago importante.\n" + //
                "\n" + //
                "Además, esta característica también podría ayudar a aumentar la retención de clientes y mejorar la experiencia general del usuario, lo que contribuiría positivamente a la reputación de su banco.\n" + //
                "\n" + //
                "Por favor, consideren esta solicitud y evalúen la viabilidad de implementar esta función en su plataforma en línea. Estoy seguro de que muchos clientes, incluido yo mismo, apreciaríamos enormemente esta mejora en el servicio.\n" + //
                "\n" + //
                "Quedo a la espera de su respuesta y agradezco de antemano su atención a este asunto.");
        claims.add(claim);

        return claims;
    }

    public LinkedList<Claim> getClaim() {
        LinkedList<Claim> claimAux = new LinkedList<Claim>();
        for (Claim claim : claims) {
            claimAux.offer(claim);
        }
        uploadTurn();
        return claimAux;
    }

    public void addClaim(Claim newClaim) {
        claims.add(newClaim);
        uploadTurn();
    }

    private void uploadTurn() {
        int actualTurn = 1;
        for (Claim order : claims) {
            order.setTurn(actualTurn);
            actualTurn++;
        }
        lastTurn = actualTurn - 1;
    }

    public Claim deleteClaim() {
        Claim deletedClail = null;
        deletedClail = claims.remove();
        uploadTurn();
        return deletedClail;
    }

    public Claim firstClaim(LinkedList<Claim> claims) {
        return claims.peek();
    }

    public int getLastTurn(){
        return lastTurn;
    }

}
