package com.company.spring

/**
 * @AUTHOR: 小于
 * @DATE: [2019/12/4  23:42]
 * @DESC:
 */

def file = new File("D:\\wp\\electron-v6.0.12-win32-x64.zip")

def files = new ArrayList<>()

for (int i = 0; i < 3; i++) {
    files.add(new File("D:\\wp\\scala-intellij-bin-2018.1.10_" + i + ".zip"))
}

parts(file,20.0*1024*1024)
//combine(files)


def combine(List<File> fs) {
    println(fs)
    if (fs != null && fs.size() > 0) {
        println(fs.get(0).getCanonicalPath())
        File targetFile = new File(fs.get(0).getParentFile(), getFileName(fs.get(0)).replace('_0', '') + ".zip")
        byte[] datas = new byte[1024 * 1024]
        FileOutputStream fos = null
        try {
            println(targetFile.getCanonicalPath())
            if (!targetFile.exists()) {
                targetFile.createNewFile()
            }
            fos = new FileOutputStream(targetFile);
            for (File f : fs) {
                FileInputStream input = null
                try {
                    input = new FileInputStream(f)
                    int len = input.read(datas)
                    while (len != -1) {
                        fos.write(datas, 0, len)
                        len = input.read(datas)
                    }

                } catch (Exception e) {
                    e.printStackTrace()
                } finally {
                    input.close()
                }

            }
        } catch (Exception e) {
            e.printStackTrace()
        } finally {
            if (fos != null)
                fos.close()
        }
    }
}

def getFileName(File file) {
    String name = file.getName()
    if (name.lastIndexOf(".") != -1) {
        return name.substring(0, name.lastIndexOf("."))
    }
    return name
}

// 20MB
def parts(File file, double  limit = 20.0*1024*1024) {
    def input = null
    FileOutputStream[] fos = null
    try {
        input = new FileInputStream(file)
        int num = getNumPart(file.size(), limit)
        byte[] buff = new byte[1024 * 1024]
        int len = input.read(buff)
        long totalBytes = 0
        fos = new FileOutputStream[num]
        for (int i = 0; i < num; i++) {
            fos[i] = new FileOutputStream(new File(file.getParent(), getFileName(file) + "_" + i + ".zip"))
        }
        while (len != -1) {
            totalBytes += len
            fos[getNumPart(totalBytes,limit)-1].write(buff,0,len)
            len = input.read(buff)
        }
    } catch (Exception e) {
        e.printStackTrace()
    } finally {
        if (input != null) input.close()

        for (FileOutputStream f : fos) {
            f.close()
        }
    }
}

int getNumPart(long size, double limit) {

    double parts = size / limit
    int partsInt = (int) (parts)
    if (parts - partsInt == 0) {
        return partsInt
    } else return partsInt + 1
}