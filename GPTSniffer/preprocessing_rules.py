import os
import pandas as pd
import re

FOLDER_OLD = "CROSS_C7"
FOLDER = "CROSS_C8"
TESTING_IN = os.path.join(FOLDER_OLD, "testing_data")
TRAINING_IN = os.path.join(FOLDER_OLD, "training_data")
TESTING_OUT = os.path.join(FOLDER, "testing_data")
TRAINING_OUT = os.path.join(FOLDER, "training_data")

def get_files(folder="/Users/juri/development/git/intro-to-java-programming/"):
    lista = set()
    for path, subdirs, files in os.walk(folder):
        for name in files:
            if name.endswith(".java"):
                lista.add(name)
    return lista

def get_class_name(name, implementation=5):
    worked2 = pd.read_csv("finale.csv")
    name = name.replace("1_","0_")
    worked2 = worked2[worked2['Exercise ID']== name]
    if(len(worked2.index) == 0):
        return name
    else:
        return worked2.iloc[0][implementation]


def remove_imports(text):
    res = re.findall(r'(import(.)*ch_(.)*;)', text)
    risultato = []
    for (a,b,c) in res:
        lista = [a,b,c]
        applicazione = sorted(lista, key=len, reverse=True)
        risultato.append(applicazione[0])
    for com in risultato:
        text = text.replace(com,"")
    return text

def remove_all_imports(text):
    res = ''
    lines = text.splitlines();
    for line in lines:
        if not line.startswith('import'):
            res = res + line + "\n"
    return res

def remove_imports(text):
    res = re.findall(r'(import(.)*ch_(.)*;)', text)
    risultato = []
    for (a,b,c) in res:
        lista = [a,b,c]
        applicazione = sorted(lista, key=len, reverse=True)
        risultato.append(applicazione[0])
    for com in risultato:
        text = text.replace(com,"")
    return text
def remove_formatting_characters(text):
    return text.replace("\t","").replace("\n","").replace("  ", " ")

def replace_class_name(text, name, implementation=7):
    name = get_class_name(name, implementation)
    res = re.findall(r'class Exercise(.*){', text)
    risultato = []
    for e in res:
       risultato.append(e)
    if len(risultato)>1: return 'FALSE'
    for com in risultato:
        text = text.replace(f'Exercise{com}',f'{name}')
    return text

def remove_comments(text):
    matches = re.findall(r'(/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+/)|(//.*)', text)
    ttbr = []
    for (a,b,c,d,e) in matches:
        list = [a,b,c,d,e]
        ttbr.append(sorted(list, key=len, reverse=True)[0])
    for com in ttbr:
        text = text.replace(com,"")
    return text

def remove_package(text):
    ris = ''
    for line in text.splitlines():
        if line.startswith('package'):
            text = text.replace(line,"")
            break
    return text


def preprocess_string(text, rm_pkg=False, rm_imports = False, rm_cmt = False, rm_all_imports = False, rn_class = False, rm_for_chars = False):
    if rm_imports: text = remove_imports(text)
    if rm_pkg: text = remove_package()
    if rm_cmt: text = remove_comments(text)
    if rm_all_imports: text = remove_all_imports(text)
    if rn_class:
        if(v.startswith("1_")): text = replace_class_name(text)
    if rm_for_chars: text = remove_formatting_characters(text)
    return text

if __name__ == '__main__':
    file_list = get_files(folder=TESTING_IN)
    if not os.path.exists(TESTING_OUT):
        os.mkdir(TESTING_OUT)
    for v in file_list:
        try:
            with open(os.path.join(TESTING_IN, v)) as reader:
                parsed_string = reader.read()
                preprocess_string(parsed_string, rm_pkg=False, rm_imports = False, rm_cmt = False, rm_all_imports = False, rn_class = False, rm_for_chars = False)
                with open(os.path.join(TESTING_OUT, v), "w") as writer: writer.write(parsed_string)
        except Exception as e:
            print(e)
    file_list = get_files(folder=TRAINING_IN)

    if not os.path.exists(TRAINING_OUT):
        os.mkdir(TRAINING_OUT)
    for v in file_list:
        try:
            with open(os.path.join(TRAINING_IN, v)) as reader:
                parsed_string = reader.read()
                preprocess_string(parsed_string, rm_pkg=False, rm_imports=False, rm_cmt=False, rm_all_imports=False,
                                  rn_class=False, rm_for_chars=False)
            with open(os.path.join(TRAINING_OUT, v), "w") as writer: writer.write(parsed_string)
        except Exception as e:
            print(e)