package br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.validacoes;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

/**
 * Anotação para validar um número de CEP
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Pattern(regexp = "^$|[a-zA-Z\\d/.-]{1,}",
        message = "Apenas letras números ou os caracteres a seguir são aceitos para o RG: / . -")
@Constraint(validatedBy = {})
public @interface RG {

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
