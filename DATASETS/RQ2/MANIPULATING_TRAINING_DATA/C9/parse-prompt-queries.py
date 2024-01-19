import pandas as pd
import os
df = pd.read_csv("PromptChatGPTQueries.csv")
out_forler = "CONF/testing_data/"
for key, value in df.iterrows():
    if not pd.isna(value['Prompt Engineering']):
        with open(os.path.join(out_forler,value['Exercise ID']),"w") as writer:
            writer.write(value['Prompt Engineering'])
