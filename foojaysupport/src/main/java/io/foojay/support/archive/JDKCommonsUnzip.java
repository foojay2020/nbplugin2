package io.foojay.support.archive;

import com.google.common.base.MoreObjects;
import java.io.File;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.openide.windows.InputOutput;

public class JDKCommonsUnzip extends CommonsUnzip {

    private final static File[] EMPTY_FILES = new File[0];

    @Override
    public void uncompress(File zip, File targetDir, InputOutput io) throws IOException {
        super.uncompress(zip, targetDir, io);

        //TODO: This is hack to set permissions until I see why Apache Compress does not read them.
        File bin = findBin(targetDir);

        if (bin != null) {
            for (File exe : MoreObjects.firstNonNull(bin.listFiles(), EMPTY_FILES)) {
                if (exe.isFile())
                    exe.setExecutable(true);
            }
        }
    }

    public static @Nullable File findBin(File outputDir) {
        for (File f : MoreObjects.firstNonNull(outputDir.listFiles(), EMPTY_FILES)) {
            if (f.isDirectory() && f.getName().equals("bin"))
                return f;
        }
        for (File f : MoreObjects.firstNonNull(outputDir.listFiles(), EMPTY_FILES)) {
            if (f.isDirectory()) {
                File sub = findBin(f);
                if (sub != null)
                    return sub;
            }
        }
        return null;
    }

}
