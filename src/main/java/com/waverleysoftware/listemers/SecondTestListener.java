package com.waverleysoftware.listemers;

import com.waverleysoftware.data.api.DataReader;
import lombok.extern.slf4j.Slf4j;
import one.util.streamex.StreamEx;
import org.apache.commons.lang3.NotImplementedException;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import java.util.ArrayList;
import java.util.List;

import static com.waverleysoftware.utils.ServiceLoaderUtils.load;
import static org.apache.commons.io.FilenameUtils.getExtension;

@Slf4j
@SuppressWarnings("JavadocType")
public class SecondTestListener implements ISuiteListener {

    private static final List<DataReader> READERS = new ArrayList<>();

    @Override
    public void onStart(final ISuite suite) {
        log.info("Start!!!!");
        READERS.addAll(load(DataReader.class, ClassLoader.getSystemClassLoader()));
    }

    @Override
    public void onFinish(final ISuite suite) {
        READERS.clear();
        log.info("Finish!!!!");
    }

    public static DataReader getImplByDataSource(final String dataSource) {
        return StreamEx.of(READERS)
                .findFirst(impl -> impl.getEntityType().equals(getExtension(dataSource)))
                .orElseThrow(() -> new NotImplementedException("No implement found"));
    }
}
