package teampearl.cvgenerator.back_end;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.PojoClassFilter;
import com.openpojo.reflection.filters.FilterClassName;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import org.junit.jupiter.api.Test;

public class PojoTester {

    public static final String[] THINGS_TO_TEST = {"teampearl.cvgenerator.back_end.presentation_layer.dto", "teampearl.cvgenerator.back_end.data_access_layer.entities"};

    @Test
    public void testPojoStructureAndBehaviour() {
        Validator validator = ValidatorBuilder.create()
                .with(new GetterMustExistRule())
                .with(new SetterMustExistRule())
                .with(new SetterTester())
                .with(new GetterTester())
                .build();

        for (String test : THINGS_TO_TEST) {
            validator.validate(test,
//                    new FilterClassNameNot("TrainingParticipationDTO*"),
                    new FilterClassNameNot("Participation*"),
                    new FilterTestClasses());
        }
    }
    
    private static class FilterClassNameNot extends FilterClassName {
        public FilterClassNameNot(String regex) {
            super(regex);
        }
        public boolean include (PojoClass pojoClass) {
            return !super.include(pojoClass);
        }
    }

    private static class FilterTestClasses implements PojoClassFilter {
        public boolean include (PojoClass pojoClass) {
            return !pojoClass.getSourcePath().contains("/test-classes/");
        }
    }
}