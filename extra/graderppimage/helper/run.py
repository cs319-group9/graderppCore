import subprocess
import sys
import json

if __name__ == "__main__":
    compile_res = True
    compile_log = ""
    grade_log = []
    memory = []
    time = []

    WORK_DIR = "/isolate"

    p = subprocess.Popen(["./isolate", "--init"], cwd=WORK_DIR)
    p.wait()

    p = subprocess.Popen("cp /tmp/compile/* /tmp/box/0/box/", shell=True)
    p.wait()
    p = subprocess.Popen("cp /tmp/submission/kod.cpp /tmp/box/0/box/", shell=True)
    p.wait()
    p = subprocess.Popen(["./isolate", "--processes=0", "--full-env", "--run", "--", "/usr/bin/make"], stdout=subprocess.PIPE, stderr=subprocess.PIPE, cwd=WORK_DIR)
    out, err = p.communicate()
    if p.returncode != 0:
        compile_res = False
        compile_log = out + err
    else:
        for i in range(int(sys.argv[1])):
            p = subprocess.Popen(["cp /tmp/input/inp" + str(i) + ".txt /tmp/box/0/box/"], shell=True)
            p.wait()
            p = subprocess.Popen(["./isolate", "--time=1", "--mem=30000", "--run", "--", "./a.out"], stdout=subprocess.PIPE, stderr=subprocess.PIPE, cwd=WORK_DIR)
            out, err = p.communicate()
            if err == "Time limit exceeded":
                grade_log.append(3) 
            if not "OK" in err:
                grade_log.append(2)
                print err
            else:
                f = open("/tmp/output/out" + str(i) + ".txt", "r")
                real_out = f.read()
                if out == real_out:
                    grade_log.append(0)
                else:
                    grade_log.append(4)
            memory.append(1327)
            time.append(0.7)
    
    res = {
        "compileSuccess": compile_res, 
        "compileLog": compile_log,
        "grade_log": grade_log,
        "time": time,
        "memory": memory
    }
    print json.dumps(res)
        
