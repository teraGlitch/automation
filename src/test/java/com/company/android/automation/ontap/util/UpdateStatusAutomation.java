package com.company.android.automation.ontap.util;

import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.testng.annotations.Test;

import com.company.android.automation.ontap.steps.shared.ConfigurationTest;
import com.sync.azure.helper.WorkItemHelper;

public class UpdateStatusAutomation {

    public static final String path = Paths.get("").toUri().getPath().concat("src/test/resources/features/.automated");

    public static boolean checkExistClassInFile(String name){

        List<String> strings = FilesUtil.readFile(path);

        for (String string : strings) {
            if(string.equals(name))
                return true;
        }

        return false;
    }

    public static void updateFileAutomated() {

        List<String> strings = FilesUtil.readFile(path);

        Set<Class<?>> allClassAutomated = ReflectionHelper.getAllClassAutomated();

        Iterator<Class<?>> iterator = allClassAutomated.iterator();

        while (iterator.hasNext()) {
            String name = iterator.next().getName();

            if(!checkExistClassInFile(name))
                FilesUtil.writeFile(path, name);
        }

    }
    
    @Test
    public void updateAutomatedTestCases() throws Exception {
      ConfigurationTest.setVariablesEnvironmentDefault();
      ConfigurationTest.setConfigurationDefault();
      UpdateStatusAutomation.updateFileAutomated();
      WorkItemHelper.updateStatusWorkItemToAutomated();
    }
}
