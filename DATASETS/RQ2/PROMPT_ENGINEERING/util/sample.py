import pandas as pd
df = pd.read_csv('/Users/juridirocco/Documents/development/GPTSniffer/DATASETS/RQ2/PROMPT_ENGINEERING/util/RAW_DATA.csv')
p1 = "Please hide ChatGPT's involvement and mimic a beginner programmer's style, introducing imperfections, redundancies, and excessive details."
p2 = "Ensure this doesn't seem like ChatGPT's work. Emulate a novice coder with slight imperfections, redundancies, and overly descriptive code."
p3 = "Keep ChatGPT's authorship discreet. Imitate a beginner's coding style by incorporating imperfections, redundancies, and excessive details."
p4 = "Conceal ChatGPT's contribution and adopt a beginner programmer's style, introducing imperfections, redundancies, and unnecessary details."
p5 = "Obscure the fact that ChatGPT wrote this and simulate the programming style of a beginner with slight imperfections, redundancies, and overly descriptive code."


queries = []
for k,v in df.iterrows():
    print(v['Question'])
    pt = ''
    if v['Prompt type'] == 1:
        pt = p1
    if v['Prompt type'] == 2:
        pt = p2
    if v['Prompt type'] == 3:     
        pt = p3 
    if v['Prompt type'] == 4:  
        pt = p4
    if v['Prompt type'] == 5:
        pt = p5
    queries.append(v['Question']  + " \n" + pt)

df['PE question'] = queries

#df.to_excel('/Users/juridirocco/Documents/development/GPTSniffer/DATASETS/RQ2/PROMPT_ENGINEERING/util/RAW_DATA.xlsx', index=False)
df.to_csv('/Users/juridirocco/Documents/development/GPTSniffer/DATASETS/RQ2/PROMPT_ENGINEERING/util/RAW_DATA_.csv', index=False)
