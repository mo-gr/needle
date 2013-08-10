package de.akquinet.jbosscc.needle.configuration;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.inject.Inject;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import de.akquinet.jbosscc.needle.MyComponent;
import de.akquinet.jbosscc.needle.injection.CustomMyComponentInjectionProviderInstancesSupplier;
import de.akquinet.jbosscc.needle.junit.testrule.NeedleTestRule;

/**
 * The needle-mockito properties file sets the custom.instances.supplier.classes
 * property to {@link CustomMyComponentInjectionProviderInstancesSupplier}. The
 * test verifies, that the component instance defined in the supplier is used
 * for injection.
 */
public class LoadInstancesSupplierFromProperties {

//    // load mockito resource and switch back to default after().
//    @ClassRule
//    public static NeedleConfigurationResetRule configurationReset = new NeedleConfigurationResetRule("needle-mockito");

    @Rule
    public final NeedleTestRule needle = new NeedleTestRule(this);

    @Inject
    private MyComponent component;

    @Test
    public void shouldInjectMyComponentWithFoo() {
        assertThat(component.testMock(), is(CustomMyComponentInjectionProviderInstancesSupplier.ID));
    }

}