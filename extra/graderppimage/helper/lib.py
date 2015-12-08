import subprocess

compile_res = True
compile_log = ""
grade_log = []
memory = []
time = []

WORK_DIR = "/isolate"

p = subprocess.Popen(["./isolate", "--init"], cwd=WORK_DIR)
p.wait()

def compile():
    p = subprocess.Popen(["cp", "/tmp/compile/*", "/tmp/box/0/box/"])
    p.wait()
    p = subprocess.Popen(["cp", "/tmp/submission/kod.cpp", "/tmp/box/0/box/"])
    p.wait()
    p = subprocess.Popen(["./isolate", "--processes=0", "--full-env", "--run", "--", "/bin/make"], stdout=subprocess.PIPE, stderr=subprocess.PIPE, cwd=WORK_DIR)
    out, err = p.communicate()
    if p.returncode != 0:
        compile_res = False
        compile_log = out + err

testcase = 0
def run():
    p = subprocess.Popen(["./isolate", "--time=1", "--mem=300000", "--run", "--", "/bin/make"], stdout=subprocess.PIPE, stderr=subprocess.PIPE, cwd=WORK_DIR)
    out, err = p.communicate()
    if p.returncode != 0:
        compile_res = False
        compile_log = out + err

    testcase++