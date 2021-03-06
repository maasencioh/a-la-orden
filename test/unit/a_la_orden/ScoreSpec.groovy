package a_la_orden

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Score)
class ScoreSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "null"() {
        expect: "crea una calificacion"
        def score = new Score (
                score: num,
                description: description,
                date: date
        )
        score.validate() == valid

        where: "valida la calificacion"
        num  | description | date | valid
        null | "well done" | 123  | false
        5    | null        | 123  | true
        5    | "well done" | null | false
        5    | "well done" | 123  | true
    }

    void "score"() {
        expect: "crea una calificacion"
        def score = new Score (
                score: num,
                description: description,
                date: date
        )
        score.validate() == valid

        where: "valida la calificacion"
        num  | description | date | valid
        -1   | "well done" | 123  | false
        0    | "well done" | 123  | false
        1    | "well done" | 123  | true
        2.5  | "well done" | 123  | true
        5    | "well done" | 123  | true
        6    | "well done" | 123  | false
    }
}
